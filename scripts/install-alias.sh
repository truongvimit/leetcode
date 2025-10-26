#!/bin/bash
# Install global leetcode command alias

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
CLI_PATH="$(cd "$SCRIPT_DIR/../build/cli" && pwd)/leetcode"

# Determine shell config file
if [ -n "$ZSH_VERSION" ]; then
    SHELL_CONFIG="$HOME/.zshrc"
elif [ -n "$BASH_VERSION" ]; then
    SHELL_CONFIG="$HOME/.bashrc"
else
    SHELL_CONFIG="$HOME/.profile"
fi

echo "🔧 Installing leetcode command..."
echo "📝 Adding alias to $SHELL_CONFIG"

# Remove existing alias if present
grep -v "alias leetcode=" "$SHELL_CONFIG" > temp_config 2>/dev/null || touch temp_config
mv temp_config "$SHELL_CONFIG"

# Add new alias
echo "" >> "$SHELL_CONFIG"
echo "# LeetCode CLI Tool" >> "$SHELL_CONFIG"
echo "alias leetcode='$CLI_PATH'" >> "$SHELL_CONFIG"

echo "✅ Alias installed successfully!"
echo "💡 Restart terminal or run: source $SHELL_CONFIG"
echo "🎯 Usage: leetcode help"
