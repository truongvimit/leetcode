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
	@read -p "Problem number: " num; \
	read -p "Problem name: " name; \
	read -p "Category (arrays/strings/trees/etc): " cat; \
	read -p "Difficulty (easy/medium/hard): " diff; \
	mkdir -p src/$cat/$diff; \
	file="src/$cat/$diff/Problem$(printf %03d $num)_$name.kt"; \
	echo "/**" > $file; \
	echo " * Problem $num: $name" >> $file; \
	echo " * https://leetcode.com/problems/$name/" >> $file; \
	echo " * $diff | TODO: Add tags" >> $file; \
	echo " *" >> $file; \
	echo " * TODO: Add description" >> $file; \
	echo " * Time: O(?), Space: O(?)" >> $file; \
	echo " */" >> $file; \
	echo "" >> $file; \
	echo "package $cat.$diff" >> $file; \
	echo "" >> $file; \
	echo "class Problem$(printf %03d $num)_$name {" >> $file; \
	echo "" >> $file; \
	echo "    fun solve(): Unit {" >> $file; \
	echo "        TODO(\"Implement solution\")" >> $file; \
	echo "    }" >> $file; \
	echo "}" >> $file; \
	echo "" >> $file; \
	echo "// Test directly in problem file" >> $file; \
	echo "fun main() {" >> $file; \
	echo "    val solution = Problem$(printf %03d $num)_$name()" >> $file; \
	echo "    " >> $file; \
	echo "    // Test cases" >> $file; \
	echo "    println(\"=== Problem $num: $name ===\")" >> $file; \
	echo "    // TODO: Add test cases" >> $file; \
	echo "    println(\"✅ Tests completed!\")" >> $file; \
	echo "}" >> $file; \
	echo "✅ Created: $file"; \
	open $file || code $file || echo "📝 Edit: $file"

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
	@read -p "Problem number: " num; \
	file=$(find src -name "Problem$(printf %03d $num)_*.kt" | head -1); \
	if [ -f "$file" ]; then \
		echo "🧪 Running $file..."; \
		kotlinc $file -include-runtime -d temp.jar && \
		java -jar temp.jar && \
		rm -f temp.jar; \
	else \
		echo "❌ Problem $num not found in src/"; \
	fi

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