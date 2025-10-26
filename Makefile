.PHONY: help new push

help: ## Show commands
	@grep -E '^[a-zA-Z_-]+:.*?## .*' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "  %-8s %s\n", $$1, $$2}'

new: ## Create problem
	@read -p "Problem number: " num; \
	read -p "Problem name: " name; \
	mkdir -p problems; \
	echo "// Problem $$num: $$name" > problems/Problem$$num.kt; \
	echo "fun main() {" >> problems/Problem$$num.kt; \
	echo "    // TODO: Solve problem here" >> problems/Problem$$num.kt; \
	echo "}" >> problems/Problem$$num.kt; \
	echo "✅ Created: problems/Problem$$num.kt"; \
	open problems/Problem$$num.kt || code problems/Problem$$num.kt || echo "📝 Edit: problems/Problem$$num.kt"

push: ## Push to GitHub
	@read -p "Commit message (or press Enter): " msg; \
	git add .; \
	if [ -z "$$msg" ]; then \
		git commit -m "🚀 Update solutions"; \
	else \
		git commit -m "✨ $$msg"; \
	fi; \
	git push; \
	echo "🎉 Pushed to GitHub!"