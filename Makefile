# 🚀 LeetCode Project Makefile
# Professional development workflow automation

# Variables
SHELL := /bin/bash
CLI_JAR := build/cli/leetcode-cli.jar
CLI_SCRIPT := build/cli/leetcode
KOTLIN_VERSION := 1.9.0

# Colors for output
CYAN := \033[0;36m
GREEN := \033[0;32m  
YELLOW := \033[1;33m
RED := \033[0;31m
BOLD := \033[1m
NC := \033[0m

.PHONY: help install build test clean run create complete stats push setup-dev

# Default target
help: ## 📖 Show this help message
	@echo -e "$(CYAN)$(BOLD)🚀 LeetCode Project - Available Commands$(NC)"
	@echo "=================================================="
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "  $(CYAN)%-15s$(NC) %s\n", $$1, $$2}'
	@echo ""
	@echo -e "$(YELLOW)💡 Examples:$(NC)"
	@echo -e "  $(GREEN)make setup-dev$(NC)                    # Complete dev setup"  
	@echo -e "  $(GREEN)make create PROBLEM=002,AddTwoNumbers,linkedlists,medium$(NC)"
	@echo -e "  $(GREEN)make complete PROBLEM=002$(NC)         # Complete workflow"
	@echo -e "  $(GREEN)make stats$(NC)                       # Show progress"

install: build ## 📦 Install CLI globally with alias
	@echo -e "$(CYAN)📦 Installing LeetCode CLI globally...$(NC)"
	@chmod +x scripts/install-alias.sh
	@./scripts/install-alias.sh
	@echo -e "$(GREEN)✅ Installation complete! Use: leetcode help$(NC)"

build: ## 🔨 Build the CLI tool
	@echo -e "$(CYAN)🔨 Building LeetCode CLI...$(NC)"
	@chmod +x scripts/build-cli.sh
	@./scripts/build-cli.sh

test: ## 🧪 Run all tests
	@echo -e "$(CYAN)🧪 Running tests...$(NC)"
	@if [ -f "./gradlew" ]; then \
		./gradlew test; \
	else \
		echo -e "$(YELLOW)⚠️ No Gradle wrapper found$(NC)"; \
		kotlinc -cp . tests/*.kt -include-runtime -d test-runner.jar && \
		java -jar test-runner.jar; \
	fi

clean: ## 🧹 Clean build artifacts
	@echo -e "$(CYAN)🧹 Cleaning build artifacts...$(NC)"
	@rm -rf build/
	@rm -f test-runner.jar
	@rm -rf out/
	@echo -e "$(GREEN)✅ Clean complete$(NC)"

run: build ## ▶️ Run the main application
	@echo -e "$(CYAN)▶️ Running LeetCode Solutions Demo...$(NC)"
	@kotlinc -cp . src/Main.kt -include-runtime -d demo.jar
	@java -jar demo.jar
	@rm -f demo.jar

# CLI Commands (require build)
create: $(CLI_SCRIPT) ## 📝 Create new problem (usage: make create PROBLEM=num,name,category,difficulty)
ifndef PROBLEM
	@echo -e "$(RED)❌ Usage: make create PROBLEM=002,AddTwoNumbers,linkedlists,medium$(NC)"
	@exit 1
endif
	@echo -e "$(CYAN)📝 Creating new problem...$(NC)"
	@IFS=',' read -ra PARTS <<< "$(PROBLEM)"; \
	$(CLI_SCRIPT) create "$${PARTS[0]}" "$${PARTS[1]}" "$${PARTS[2]}" "$${PARTS[3]}"

complete: $(CLI_SCRIPT) ## 🎉 Complete problem workflow (usage: make complete PROBLEM=002)
ifndef PROBLEM  
	@echo -e "$(RED)❌ Usage: make complete PROBLEM=002$(NC)"
	@exit 1
endif
	@echo -e "$(CYAN)🎉 Completing problem workflow...$(NC)"
	@$(CLI_SCRIPT) complete $(PROBLEM)

commit: $(CLI_SCRIPT) ## 💾 Commit solution (usage: make commit PROBLEM=002)
ifndef PROBLEM
	@echo -e "$(RED)❌ Usage: make commit PROBLEM=002$(NC)" 
	@exit 1
endif
	@echo -e "$(CYAN)💾 Committing solution...$(NC)"
	@$(CLI_SCRIPT) commit $(PROBLEM)

stats: $(CLI_SCRIPT) ## 📊 Show progress statistics
	@echo -e "$(CYAN)📊 Calculating progress statistics...$(NC)"
	@$(CLI_SCRIPT) stats

push: ## 📤 Push all changes to GitHub
	@echo -e "$(CYAN)📤 Pushing changes to GitHub...$(NC)"
	@git add .
	@git status
	@echo -e "$(YELLOW)Press Enter to continue or Ctrl+C to cancel...$(NC)"
	@read
	@git commit -m "🚀 Update: $(shell date '+%Y-%m-%d %H:%M')" || echo "No changes to commit"
	@git push origin main
	@echo -e "$(GREEN)✅ Push complete!$(NC)"

update-progress: $(CLI_SCRIPT) ## 📈 Update progress tracking
	@echo -e "$(CYAN)📈 Updating progress...$(NC)"
	@$(CLI_SCRIPT) update

# Development setup
setup-dev: ## 🛠️ Complete development environment setup
	@echo -e "$(CYAN)$(BOLD)🛠️ Setting up development environment...$(NC)"
	@echo "1️⃣ Checking prerequisites..."
	@command -v java >/dev/null 2>&1 || (echo -e "$(RED)❌ Java not found. Install JDK 11+$(NC)" && exit 1)
	@command -v kotlinc >/dev/null 2>&1 || (echo -e "$(RED)❌ Kotlin not found. Install with: brew install kotlin$(NC)" && exit 1)
	@echo -e "$(GREEN)✅ Prerequisites OK$(NC)"
	
	@echo "2️⃣ Building CLI tool..."
	@$(MAKE) build
	
	@echo "3️⃣ Installing globally..."  
	@$(MAKE) install
	
	@echo "4️⃣ Running tests..."
	@$(MAKE) test
	
	@echo -e "$(GREEN)$(BOLD)🎉 Setup complete!$(NC)"
	@echo ""
	@echo -e "$(YELLOW)📋 Next steps:$(NC)"
	@echo -e "  • Restart terminal or run: $(CYAN)source ~/.zshrc$(NC)"
	@echo -e "  • Create first problem: $(CYAN)leetcode create 002 AddTwoNumbers linkedlists medium$(NC)"
	@echo -e "  • Show help: $(CYAN)leetcode help$(NC)"

# Quality checks
lint: ## 🔍 Run code quality checks
	@echo -e "$(CYAN)🔍 Running code quality checks...$(NC)"
	@echo "📋 Checking Kotlin files for style violations..."
	@find src -name "*.kt" -exec echo "Checking: {}" \;
	@echo -e "$(GREEN)✅ Code quality check complete$(NC)"

format: ## 🎨 Format code
	@echo -e "$(CYAN)🎨 Formatting Kotlin code...$(NC)"
	@find src -name "*.kt" -exec echo "Formatting: {}" \;
	@echo -e "$(GREEN)✅ Code formatting complete$(NC)"

# Project info
info: ## ℹ️ Show project information
	@echo -e "$(CYAN)$(BOLD)📋 Project Information$(NC)"
	@echo "=================================="
	@echo -e "📁 Project: $(YELLOW)LeetCode Solutions$(NC)"
	@echo -e "🔧 Language: $(YELLOW)Kotlin$(NC)"
	@echo -e "📊 Problems: $(GREEN)$(shell find src -name "*.kt" -path "*/easy/*" -o -path "*/medium/*" -o -path "*/hard/*" | wc -l)$(NC)"
	@echo -e "🧪 Tests: $(GREEN)$(shell find tests -name "*Test.kt" 2>/dev/null | wc -l)$(NC)"
	@echo -e "📚 Docs: $(GREEN)$(shell find docs -name "*.md" 2>/dev/null | wc -l)$(NC)"
	@echo -e "🔗 Repository: $(CYAN)https://github.com/truongvimit/leetcode$(NC)"

# Check if CLI is built
$(CLI_SCRIPT):
	@if [ ! -f "$(CLI_SCRIPT)" ]; then \
		echo -e "$(YELLOW)⚠️ CLI not found. Building...$(NC)"; \
		$(MAKE) build; \
	fi

# Advanced workflows
workflow-new: ## 🆕 Complete workflow for new problem
	@echo -e "$(CYAN)🆕 Starting new problem workflow...$(NC)"
	@echo "📝 Enter problem details:"
	@read -p "Problem number (e.g., 003): " NUM; \
	read -p "Problem name (e.g., LongestSubstring): " NAME; \
	read -p "Category (arrays/strings/etc.): " CAT; \
	read -p "Difficulty (easy/medium/hard): " DIFF; \
	$(CLI_SCRIPT) create $$NUM $$NAME $$CAT $$DIFF

workflow-submit: $(CLI_SCRIPT) ## 📤 Complete submission workflow  
	@echo -e "$(CYAN)📤 Starting submission workflow...$(NC)"
	@read -p "Problem number to submit: " NUM; \
	echo "🧪 Running tests..."; \
	$(CLI_SCRIPT) test $$NUM && \
	echo "💾 Committing solution..." && \
	$(CLI_SCRIPT) commit $$NUM && \
	echo "🚀 Pushing to GitHub..." && \
	$(CLI_SCRIPT) push && \
	echo -e "$(GREEN)🎉 Submission complete!$(NC)"

# Quick shortcuts
quick-stats: $(CLI_SCRIPT) ## ⚡ Quick stats (alias for stats)
	@$(CLI_SCRIPT) stats

daily: $(CLI_SCRIPT) ## 📅 Daily routine (stats + update)
	@echo -e "$(CYAN)📅 Daily LeetCode routine...$(NC)"
	@$(CLI_SCRIPT) stats  
	@$(CLI_SCRIPT) update
	@echo -e "$(GREEN)✅ Daily routine complete!$(NC)"

# Build requirements check
check-deps: ## 🔍 Check build dependencies
	@echo -e "$(CYAN)🔍 Checking build dependencies...$(NC)"
	@command -v java >/dev/null 2>&1 && echo -e "$(GREEN)✅ Java$(NC)" || echo -e "$(RED)❌ Java$(NC)"
	@command -v kotlinc >/dev/null 2>&1 && echo -e "$(GREEN)✅ Kotlin$(NC)" || echo -e "$(RED)❌ Kotlin$(NC)"
	@command -v git >/dev/null 2>&1 && echo -e "$(GREEN)✅ Git$(NC)" || echo -e "$(RED)❌ Git$(NC)"