#!/bin/bash

# 🚀 LeetCode CLI Build Script
# Builds the CLI tool and sets up convenient usage

set -e  # Exit on any error

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
BOLD='\033[1m'
NC='\033[0m' # No Color

echo -e "${CYAN}${BOLD}🚀 Building LeetCode CLI Tool${NC}"
echo "================================================"

# Check if Kotlin is installed
if ! command -v kotlinc-jvm &> /dev/null; then
    echo -e "${RED}❌ Kotlin compiler not found!${NC}"
    echo -e "${YELLOW}💡 Install with: brew install kotlin${NC}"
    exit 1
fi

# Create build directory
echo -e "${BLUE}📁 Creating build directory...${NC}"
mkdir -p build/cli

# Compile the CLI tool
echo -e "${BLUE}⚙️  Compiling CLI tool...${NC}"
kotlinc-jvm -cp . src/cli/LeetCodeCLI.kt -include-runtime -d build/cli/leetcode-cli.jar

if [ $? -eq 0 ]; then
    echo -e "${GREEN}✅ CLI tool compiled successfully!${NC}"
else
    echo -e "${RED}❌ Compilation failed!${NC}"
    exit 1
fi

# Create wrapper script
echo -e "${BLUE}📝 Creating wrapper script...${NC}"
cat > build/cli/leetcode << 'EOF'
#!/bin/bash
# LeetCode CLI Wrapper Script

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
JAR_PATH="$SCRIPT_DIR/leetcode-cli.jar"

if [ ! -f "$JAR_PATH" ]; then
    echo "❌ CLI jar not found at $JAR_PATH"
    echo "💡 Run: ./scripts/build-cli.sh"
    exit 1
fi

java -jar "$JAR_PATH" "$@"
EOF

# Make wrapper executable
chmod +x build/cli/leetcode

# Create global alias installer
echo -e "${BLUE}🔧 Creating alias installer...${NC}"
cat > scripts/install-alias.sh << 'EOF'
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
EOF

chmod +x scripts/install-alias.sh

echo ""
echo -e "${GREEN}${BOLD}🎉 Build completed successfully!${NC}"
echo ""
echo -e "${YELLOW}📋 Next steps:${NC}"
echo -e "  ${CYAN}1.${NC} Install global alias: ${BLUE}./scripts/install-alias.sh${NC}"
echo -e "  ${CYAN}2.${NC} Restart terminal or: ${BLUE}source ~/.zshrc${NC}"
echo -e "  ${CYAN}3.${NC} Test command: ${BLUE}leetcode help${NC}"
echo ""
echo -e "${YELLOW}📖 Usage examples:${NC}"
echo -e "  ${BLUE}leetcode create 002 AddTwoNumbers linkedlists medium${NC}"
echo -e "  ${BLUE}leetcode test 002${NC}"
echo -e "  ${BLUE}leetcode complete 002${NC}"
echo -e "  ${BLUE}leetcode stats${NC}"
echo ""
echo -e "${GREEN}🚀 Happy coding!${NC}"