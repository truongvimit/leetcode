#!/bin/bash

# Set locale to avoid encoding issues
export LANG=en_US.UTF-8
export LC_ALL=en_US.UTF-8

# Create new LeetCode problem file

read -p "Problem number: " num
read -p "Problem name: " name  
read -p "Category (arrays/strings/trees/etc): " category
read -p "Difficulty (easy/medium/hard): " difficulty

# Validate inputs
if [[ ! "$num" =~ ^[0-9]+$ ]]; then
    echo "❌ Error: Problem number must be numeric"
    exit 1
fi

if [[ ! "$difficulty" =~ ^(easy|medium|hard)$ ]]; then
    echo "❌ Error: Difficulty must be easy, medium, or hard"
    exit 1
fi

# Clean category name (remove special characters)
category=$(echo "$category" | tr -cd '[:alnum:]' | tr '[:upper:]' '[:lower:]')
if [ -z "$category" ]; then
    echo "❌ Error: Category cannot be empty"
    exit 1
fi

# Format number with leading zeros
formatted_num=$(printf "%03d" $num)

# Convert kebab-case to CamelCase for class name
# add-two-numbers -> AddTwoNumbers
class_name=$(echo "$name" | awk -F'[-_ ]' '{for(i=1;i<=NF;i++) $i=toupper(substr($i,1,1)) tolower(substr($i,2))} 1' OFS='')

# Keep original name for URL (convert to lowercase and replace spaces with dashes)
url_name=$(echo "$name" | tr '[:upper:]' '[:lower:]' | sed 's/ /-/g')

# Create directory with explicit error handling
echo "📁 Creating directory: src/$category/$difficulty"
if ! mkdir -p "src/$category/$difficulty"; then
    echo "❌ Error: Failed to create directory"
    exit 1
fi

# Create file path (use class_name for file)
file_path="src/$category/$difficulty/Problem${formatted_num}_${class_name}.kt"

echo "📝 Creating file: $file_path"

# Create the file content
cat > "$file_path" << EOF
/**
 * Problem $num: $class_name
 * https://leetcode.com/problems/$url_name/
 * $difficulty | TODO: Add tags
 *
 * TODO: Add description
 * Time: O(?), Space: O(?)
 */

package $category.$difficulty

class Problem${formatted_num}_${class_name} {

    fun solve(): Unit {
        TODO("Implement solution")
    }
}

// Test directly in problem file
fun main() {
    val solution = Problem${formatted_num}_${class_name}()

    // Test cases
    println("=== Problem $num: $class_name ===")
    // TODO: Add test cases
    // solution.solve()
    println("✅ Tests completed!")
}
EOF

if [ -f "$file_path" ]; then
    echo "✅ Created: $file_path"
    echo "📝 Class: Problem${formatted_num}_${class_name}"  
    echo "🔗 URL: https://leetcode.com/problems/$url_name/"
else
    echo "❌ Error: Failed to create file"
    exit 1
fi

# Try to open in editor
if command -v code > /dev/null; then
    code "$file_path"
elif command -v open > /dev/null; then
    open "$file_path"  
else
    echo "📝 Edit: $file_path"
fi