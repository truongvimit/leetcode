#!/bin/bash

# Set locale to avoid encoding issues
export LANG=C
export LC_ALL=C

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

echo -e "${BLUE}🚀 Creating new LeetCode problem${NC}"

# Get inputs
read -p "Problem number: " num
read -p "Problem name: " name  
read -p "Category (arrays/strings/trees/etc): " category
read -p "Difficulty (easy/medium/hard): " difficulty

# Validate problem number
if [[ ! "$num" =~ ^[0-9]+$ ]]; then
    echo -e "${RED}❌ Error: Problem number must be numeric${NC}"
    exit 1
fi

# Convert to decimal to avoid octal interpretation
decimal_num=$((10#$num))

# Validate difficulty
if [[ ! "$difficulty" =~ ^(easy|medium|hard)$ ]]; then
    echo -e "${RED}❌ Error: Difficulty must be easy, medium, or hard${NC}"
    exit 1
fi

# Clean category using parameter expansion (bash built-in)
cleaned_category=""
for (( i=0; i<${#category}; i++ )); do
    char="${category:$i:1}"
    if [[ "$char" =~ [a-zA-Z0-9] ]]; then
        # Convert to lowercase
        if [[ "$char" =~ [A-Z] ]]; then
            char=$(echo "$char" | python3 -c "import sys; print(sys.stdin.read().lower().strip())")
        fi
        cleaned_category="${cleaned_category}${char}"
    fi
done

if [ -z "$cleaned_category" ]; then
    echo -e "${RED}❌ Error: Category cannot be empty after cleanup${NC}"
    echo -e "${YELLOW}💡 Try: arrays, strings, linkedlists, trees, etc.${NC}"
    exit 1
fi

# Validate name is not empty
if [ -z "$name" ]; then
    echo -e "${RED}❌ Error: Problem name cannot be empty${NC}"
    exit 1
fi

# Format number with leading zeros
formatted_num=$(printf "%03d" $decimal_num)

# Convert name to CamelCase using bash
# container-with-most-water -> ContainerWithMostWater
class_name=""
capitalize_next=true

for (( i=0; i<${#name}; i++ )); do
    char="${name:$i:1}"
    if [[ "$char" =~ [a-zA-Z0-9] ]]; then
        if [ "$capitalize_next" = true ]; then
            # Capitalize first letter
            if [[ "$char" =~ [a-z] ]]; then
                char=$(echo "$char" | python3 -c "import sys; print(sys.stdin.read().upper().strip())")
            fi
            capitalize_next=false
        else
            # Make lowercase
            if [[ "$char" =~ [A-Z] ]]; then
                char=$(echo "$char" | python3 -c "import sys; print(sys.stdin.read().lower().strip())")
            fi
        fi
        class_name="${class_name}${char}"
    else
        capitalize_next=true
    fi
done

# Create URL-friendly name using bash
# container-with-most-water -> container-with-most-water
url_name=""
for (( i=0; i<${#name}; i++ )); do
    char="${name:$i:1}"
    if [[ "$char" =~ [a-zA-Z0-9] ]]; then
        # Convert to lowercase
        if [[ "$char" =~ [A-Z] ]]; then
            char=$(echo "$char" | python3 -c "import sys; print(sys.stdin.read().lower().strip())")
        fi
        url_name="${url_name}${char}"
    elif [[ "$char" =~ [[:space:]] ]] && [ "${url_name: -1}" != "-" ]; then
        url_name="${url_name}-"
    elif [ "$char" != " " ] && [ "${url_name: -1}" != "-" ]; then
        url_name="${url_name}-"
    fi
done

# Remove trailing dash if exists
if [ "${url_name: -1}" = "-" ]; then
    url_name="${url_name%?}"
fi

echo -e "${BLUE}📋 Summary:${NC}"
echo -e "  Number: ${GREEN}$formatted_num${NC}"
echo -e "  Name: ${GREEN}$class_name${NC}"
echo -e "  Category: ${GREEN}$cleaned_category${NC}"
echo -e "  Difficulty: ${GREEN}$difficulty${NC}"
echo -e "  URL: ${GREEN}$url_name${NC}"

# Create directory
echo -e "${BLUE}📁 Creating directory: src/$cleaned_category/$difficulty${NC}"
if ! mkdir -p "src/$cleaned_category/$difficulty"; then
    echo -e "${RED}❌ Error: Failed to create directory${NC}"
    exit 1
fi

# Create file path
file_path="src/$cleaned_category/$difficulty/Problem${formatted_num}_${class_name}.kt"

echo -e "${BLUE}📝 Creating file: $file_path${NC}"

# Create the file content
cat > "$file_path" << EOF
/**
 * Problem $decimal_num: $class_name
 * https://leetcode.com/problems/$url_name/
 * $difficulty | TODO: Add tags
 *
 * TODO: Add description
 * Time: O(?), Space: O(?)
 */

package $cleaned_category.$difficulty

class Problem${formatted_num}_${class_name} {

    fun solve(): Unit {
        TODO("Implement solution")
    }
}

// Test directly in problem file
fun main() {
    val solution = Problem${formatted_num}_${class_name}()

    // Test cases
    println("=== Problem $decimal_num: $class_name ===")
    // TODO: Add test cases
    // solution.solve()
    println("✅ Tests completed!")
}
EOF

# Verify file creation
if [ -f "$file_path" ]; then
    echo -e "${GREEN}✅ Created: $file_path${NC}"
    echo -e "${GREEN}📝 Class: Problem${formatted_num}_${class_name}${NC}"  
    echo -e "${GREEN}🔗 URL: https://leetcode.com/problems/$url_name/${NC}"
else
    echo -e "${RED}❌ Error: Failed to create file${NC}"
    exit 1
fi

# Try to open in editor
if command -v code > /dev/null; then
    code "$file_path"
    echo -e "${BLUE}📂 Opened in VS Code${NC}"
elif command -v open > /dev/null; then
    open "$file_path"
    echo -e "${BLUE}📂 Opened in default editor${NC}"
else
    echo -e "${YELLOW}📝 Edit: $file_path${NC}"
fi