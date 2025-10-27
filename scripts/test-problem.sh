#!/bin/bash

# Test LeetCode problem by number

read -p "Problem number: " num

# Format number with leading zeros
formatted_num=$(printf "%03d" $num)

# Find the problem file
file=$(find src -name "Problem${formatted_num}_*.kt" | head -1)

if [ -f "$file" ]; then
    echo "🧪 Running $file..."
    
    # Compile and run
    if kotlinc "$file" -include-runtime -d temp.jar; then
        java -jar temp.jar
        rm -f temp.jar
    else
        echo "❌ Compilation failed"
        rm -f temp.jar
    fi
else
    echo "❌ Problem $num not found in src/"
    echo "💡 Available problems:"
    find src -name "Problem*.kt" | sort
fi