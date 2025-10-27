.PHONY: help new push run test clean

# Show commands
help:
	@echo "🚀 LeetCode Solutions Commands:"
	@echo "  make new      - Tạo problem mới"
	@echo "  make test     - Test by problem number"
	@echo "  make run      - Test by full file path"
	@echo "  make push     - Push to GitHub"
	@echo "  make clean    - Clean temp files"

# Tạo file problem mới
new:
	@./scripts/create-problem.sh

# Chạy test 1 problem
run:
	@read -p "Problem file path (e.g. src/arrays/easy/Problem001_TwoSum.kt): " file; \
	if [ -f "$file" ]; then \
		echo "🧪 Running $file..."; \
		kotlinc $file -include-runtime -d temp.jar && \
		java -jar temp.jar && \
		rm -f temp.jar; \
	else \
		echo "❌ File $file not found"; \
	fi

# Chạy problem cụ thể (shortcut)
test:
	@./scripts/test-problem.sh

# Đẩy lên GitHub
push:
	@read -p "Commit message (or press Enter): " msg; \
	git add .; \
	if [ -z "$msg" ]; then \
		git commit -m "🚀 Update solutions"; \
	else \
		git commit -m "✨ $msg"; \
	fi; \
	git push; \
	echo "🎉 Pushed to GitHub!"

# Dọn dẹp
clean:
	@rm -f *.jar temp.*