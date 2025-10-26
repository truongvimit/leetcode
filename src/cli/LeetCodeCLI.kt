package cli

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess

/**
 * LeetCode CLI Tool - Professional Workflow Automation
 *
 * Features:
 * - Create new problem solutions with templates
 * - Run tests automatically
 * - Auto-commit and push to GitHub
 * - Update progress tracking
 * - Generate performance reports
 *
 * Usage:
 * kotlinc-jvm -cp . src/cli/LeetCodeCLI.kt -include-runtime -d leetcode-cli.jar
 * java -jar leetcode-cli.jar [command] [options]
 */

class LeetCodeCLI {

    companion object {
        const val VERSION = "1.0.0"
        const val GITHUB_REPO = "https://github.com/truongvimit/leetcode"

        // ANSI Color codes
        const val RESET = "\u001B[0m"
        const val RED = "\u001B[31m"
        const val GREEN = "\u001B[32m"
        const val YELLOW = "\u001B[33m"
        const val BLUE = "\u001B[34m"
        const val PURPLE = "\u001B[35m"
        const val CYAN = "\u001B[36m"
        const val BOLD = "\u001B[1m"
    }

    private val categories = listOf(
        "arrays", "strings", "hashmaps", "linkedlists", "trees", "graphs",
        "dynamicprogramming", "backtracking", "sorting", "binarysearch",
        "slidingwindow", "twopointers", "greedy", "heaps", "stacks", "queues"
    )

    private val difficulties = listOf("easy", "medium", "hard")

    fun main(args: Array<String>) {
        printBanner()

        if (args.isEmpty()) {
            printHelp()
            return
        }

        when (args[0].lowercase()) {
            "create", "new" -> createProblem(args)
            "test", "t" -> runTests(args)
            "commit", "c" -> commitSolution(args)
            "push", "p" -> pushToGitHub(args)
            "complete", "done" -> completeProblem(args)
            "stats", "status" -> showStats()
            "update" -> updateProgress()
            "help", "-h", "--help" -> printHelp()
            "version", "-v", "--version" -> printVersion()
            else -> {
                println("${RED}❌ Unknown command: ${args[0]}${RESET}")
                printHelp()
            }
        }
    }

    private fun printBanner() {
        println("${CYAN}${BOLD}")
        println("╔══════════════════════════════════════╗")
        println("║          🚀 LeetCode CLI Tool        ║")
        println("║     Professional Workflow Manager    ║")
        println("╚══════════════════════════════════════╝")
        println("${RESET}")
    }

    private fun createProblem(args: Array<String>) {
        if (args.size < 4) {
            println("${RED}❌ Usage: create <number> <name> <category> [difficulty]${RESET}")
            println("${YELLOW}💡 Example: create 001 TwoSum arrays easy${RESET}")
            return
        }

        val number = args[1].padStart(3, '0')
        val name = args[2].capitalize()
        val category = args[3].lowercase()
        val difficulty = if (args.size > 4) args[4].lowercase() else "medium"

        if (!categories.contains(category)) {
            println("${RED}❌ Invalid category. Available: ${categories.joinToString()}${RESET}")
            return
        }

        if (!difficulties.contains(difficulty)) {
            println("${RED}❌ Invalid difficulty. Available: ${difficulties.joinToString()}${RESET}")
            return
        }

        createSolutionFile(number, name, category, difficulty)
        createTestFile(number, name, category, difficulty)

        println("${GREEN}✅ Created Problem$number$name successfully!${RESET}")
        println("${BLUE}📁 Solution: src/$category/$difficulty/Problem${number}_${name}.kt${RESET}")
        println("${BLUE}🧪 Test: tests/Problem${number}_${name}Test.kt${RESET}")

        // Open files in IDE
        println("\n${CYAN}💡 Opening files in IDE...${RESET}")
        openInIDE("src/$category/$difficulty/Problem${number}_${name}.kt")
    }

    private fun createSolutionFile(number: String, name: String, category: String, difficulty: String) {
        val dir = File("src/$category/$difficulty")
        if (!dir.exists()) dir.mkdirs()

        val file = File("${dir.path}/Problem${number}_${name}.kt")
        val template = generateSolutionTemplate(number, name, category, difficulty)
        file.writeText(template)
    }

    private fun createTestFile(number: String, name: String, category: String, difficulty: String) {
        val dir = File("tests")
        if (!dir.exists()) dir.mkdirs()

        val file = File("${dir.path}/Problem${number}_${name}Test.kt")
        val template = generateTestTemplate(number, name, category, difficulty)
        file.writeText(template)
    }

    private fun generateSolutionTemplate(number: String, name: String, category: String, difficulty: String): String {
        val difficultyCapital = difficulty.capitalize()
        val categoryFormatted = category.replace("programming", " Programming").capitalize()

        return """/**
 * Problem: $name
 * URL: https://leetcode.com/problems/${name.lowercase().replace(Regex("[^a-z0-9]"), "-")}/
 * Difficulty: $difficultyCapital
 * Category: $categoryFormatted
 * 
 * Description:
 * [TODO: Add problem description from LeetCode]
 * 
 * Algorithm Approach:
 * [TODO: Explain your approach here]
 * 
 * Time Complexity: O(?) - [TODO: Analyze time complexity]
 * Space Complexity: O(?) - [TODO: Analyze space complexity]
 * 
 * Example:
 * Input: [TODO: Add example input]
 * Output: [TODO: Add example output]
 * Explanation: [TODO: Explain the example]
 * 
 * Constraints:
 * [TODO: Add constraints from LeetCode]
 */

package $category.$difficulty

class Problem${number}_${name} {
    
    /**
     * Main solution
     * 
     * TODO: Implement your solution here
     * 
     * @param [TODO: Add parameters]
     * @return [TODO: Add return type and description]
     */
    fun solve(/* TODO: Add parameters */): /* TODO: Return type */ {
        TODO("Implement your solution")
    }
    
    /**
     * Alternative approach (if applicable)
     * 
     * TODO: Implement alternative solution
     */
    fun solveAlternative(/* TODO: Add parameters */): /* TODO: Return type */ {
        TODO("Implement alternative solution")
    }
}

/**
 * Interview Tips:
 * 
 * TODO: Add specific tips for this problem:
 * 1. Edge cases to consider
 * 2. Follow-up questions
 * 3. Optimization opportunities
 * 4. Related problems
 */
"""
    }

    private fun generateTestTemplate(number: String, name: String, category: String, difficulty: String): String {
        return """import $category.$difficulty.Problem${number}_${name}
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.*

class Problem${number}_${name}Test {
    
    private val solution = Problem${number}_${name}()
    
    @Test
    fun `test example 1`() {
        // TODO: Add test case from LeetCode example 1
        // val input = ...
        // val expected = ...
        // val result = solution.solve(input)
        // assertEquals(expected, result)
    }
    
    @Test
    fun `test example 2`() {
        // TODO: Add test case from LeetCode example 2
    }
    
    @Test
    fun `test edge cases`() {
        // TODO: Add edge case tests
        // - Empty input
        // - Single element
        // - Maximum constraints
        // - Minimum constraints
    }
    
    @Test
    fun `test invalid input`() {
        // TODO: Add tests for invalid input if applicable
        // assertThrows<IllegalArgumentException> {
        //     solution.solve(invalidInput)
        // }
    }
    
    @Test
    fun `test performance`() {
        // TODO: Add performance test for large inputs
        // val largeInput = ...
        // val startTime = System.currentTimeMillis()
        // val result = solution.solve(largeInput)
        // val endTime = System.currentTimeMillis()
        // assertTrue(endTime - startTime < 1000) // Should complete within 1 second
    }
}

/**
 * Test Coverage Summary:
 * 
 * ✅ LeetCode examples
 * ✅ Edge cases
 * ✅ Error conditions
 * ✅ Performance tests
 * ✅ Alternative solutions (if applicable)
 */
"""
    }

    private fun runTests(args: Array<String>) {
        println("${CYAN}🧪 Running tests...${RESET}")

        val testCommand = if (args.size > 1) {
            "kotlinc -cp . tests/Problem*${args[1]}*Test.kt && kotlin -cp . Problem*${args[1]}*TestKt"
        } else {
            "./gradlew test"
        }

        val result = executeCommand(testCommand)

        if (result.exitCode == 0) {
            println("${GREEN}✅ All tests passed!${RESET}")
            println("${result.output}")
        } else {
            println("${RED}❌ Tests failed!${RESET}")
            println("${result.error}")
        }
    }

    private fun commitSolution(args: Array<String>) {
        if (args.size < 2) {
            println("${RED}❌ Usage: commit <problem_number> [message]${RESET}")
            return
        }

        val problemNumber = args[1].padStart(3, '0')
        val customMessage = if (args.size > 2) args.drop(2).joinToString(" ") else null

        // Find the problem file
        val problemFile = findProblemFile(problemNumber)
        if (problemFile == null) {
            println("${RED}❌ Problem $problemNumber not found!${RESET}")
            return
        }

        // Generate commit message
        val commitMessage = generateCommitMessage(problemNumber, problemFile, customMessage)

        // Add and commit
        println("${CYAN}📝 Staging changes...${RESET}")
        executeCommand("git add .")

        println("${CYAN}💾 Committing solution...${RESET}")
        val commitResult = executeCommand("git commit -m \"$commitMessage\"")

        if (commitResult.exitCode == 0) {
            println("${GREEN}✅ Successfully committed solution!${RESET}")
            println("${BLUE}📨 Commit: $commitMessage${RESET}")
        } else {
            println("${RED}❌ Commit failed!${RESET}")
            println(commitResult.error)
        }
    }

    private fun pushToGitHub(args: Array<String>) {
        println("${CYAN}🚀 Pushing to GitHub...${RESET}")

        val pushResult = executeCommand("git push origin main")

        if (pushResult.exitCode == 0) {
            println("${GREEN}✅ Successfully pushed to GitHub!${RESET}")
            println("${BLUE}🌐 Repository: $GITHUB_REPO${RESET}")

            // Update progress tracking
            updateProgress()
        } else {
            println("${RED}❌ Push failed!${RESET}")
            println("${YELLOW}💡 Try: git push --set-upstream origin main${RESET}")
            println(pushResult.error)
        }
    }

    private fun completeProblem(args: Array<String>) {
        if (args.size < 2) {
            println("${RED}❌ Usage: complete <problem_number> [custom_message]${RESET}")
            return
        }

        val problemNumber = args[1]

        println("${CYAN}🔄 Complete workflow for Problem $problemNumber${RESET}")

        // Step 1: Run tests
        println("\n${BOLD}Step 1: Running tests${RESET}")
        runTests(arrayOf("test", problemNumber))

        // Step 2: Commit solution
        println("\n${BOLD}Step 2: Committing solution${RESET}")
        commitSolution(args)

        // Step 3: Push to GitHub
        println("\n${BOLD}Step 3: Pushing to GitHub${RESET}")
        pushToGitHub(arrayOf("push"))

        println("\n${GREEN}${BOLD}🎉 Problem $problemNumber completed successfully!${RESET}")
        println("${BLUE}🔗 Check your progress: $GITHUB_REPO${RESET}")
    }

    private fun showStats() {
        println("${CYAN}${BOLD}📊 LeetCode Progress Statistics${RESET}")
        println("═".repeat(40))

        val stats = calculateStats()

        println("${GREEN}✅ Completed Problems: ${stats.completed}${RESET}")
        println("${YELLOW}📝 Total Problems: ${stats.total}${RESET}")
        println("${BLUE}📈 Completion Rate: ${String.format("%.1f", stats.completionRate)}%${RESET}")

        println("\n${BOLD}By Category:${RESET}")
        stats.byCategory.forEach { (category, count) ->
            println("  ${category.padEnd(20)} : $count problems")
        }

        println("\n${BOLD}By Difficulty:${RESET}")
        stats.byDifficulty.forEach { (difficulty, count) ->
            val color = when (difficulty) {
                "easy" -> GREEN
                "medium" -> YELLOW
                "hard" -> RED
                else -> RESET
            }
            println("  $color${difficulty.capitalize().padEnd(20)} : $count problems$RESET")
        }

        println("\n${PURPLE}🏆 Keep going! You're doing great!${RESET}")
    }

    private fun updateProgress() {
        println("${CYAN}📈 Updating progress tracking...${RESET}")

        val stats = calculateStats()
        val readmeFile = File("README.md")

        if (readmeFile.exists()) {
            var content = readmeFile.readText()

            // Update progress tables in README
            content = updateProgressTable(content, stats)

            readmeFile.writeText(content)
            println("${GREEN}✅ Progress updated in README.md${RESET}")
        }
    }

    private fun generateCommitMessage(problemNumber: String, problemFile: File, customMessage: String?): String {
        val problemName = extractProblemName(problemFile)
        val difficulty = extractDifficulty(problemFile.path)
        val category = extractCategory(problemFile.path)

        return if (customMessage != null) {
            "✨ Problem $problemNumber: $customMessage"
        } else {
            "✨ Solve Problem $problemNumber: $problemName ($difficulty)\n\n" +
                    "📂 Category: ${category.capitalize()}\n" +
                    "⚡ Difficulty: ${difficulty.capitalize()}\n" +
                    "🎯 Algorithm: [Auto-generated commit]\n" +
                    "⏰ Completed: ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}"
        }
    }

    private fun findProblemFile(problemNumber: String): File? {
        val searchDirs = categories.flatMap { category ->
            difficulties.map { difficulty -> "src/$category/$difficulty" }
        }

        for (dir in searchDirs) {
            val directory = File(dir)
            if (directory.exists()) {
                directory.listFiles()?.forEach { file ->
                    if (file.name.startsWith("Problem$problemNumber") && file.extension == "kt") {
                        return file
                    }
                }
            }
        }
        return null
    }

    private fun extractProblemName(file: File): String {
        val fileName = file.nameWithoutExtension
        return fileName.substringAfter("_").replace(Regex("([A-Z])"), " $1").trim()
    }

    private fun extractDifficulty(path: String): String {
        return difficulties.find { path.contains("/$it/") } ?: "unknown"
    }

    private fun extractCategory(path: String): String {
        return categories.find { path.contains("/$it/") } ?: "unknown"
    }

    private fun calculateStats(): ProblemStats {
        val completed = mutableMapOf<String, Int>()
        val byCategory = mutableMapOf<String, Int>()
        val byDifficulty = mutableMapOf<String, Int>()

        categories.forEach { category ->
            difficulties.forEach { difficulty ->
                val dir = File("src/$category/$difficulty")
                if (dir.exists()) {
                    val count = dir.listFiles()?.count { it.extension == "kt" } ?: 0
                    if (count > 0) {
                        byCategory[category] = byCategory.getOrDefault(category, 0) + count
                        byDifficulty[difficulty] = byDifficulty.getOrDefault(difficulty, 0) + count
                    }
                }
            }
        }

        val totalCompleted = byCategory.values.sum()
        val totalPossible = 1526 // Approximate total LeetCode problems

        return ProblemStats(
            completed = totalCompleted,
            total = totalPossible,
            completionRate = (totalCompleted.toDouble() / totalPossible) * 100,
            byCategory = byCategory,
            byDifficulty = byDifficulty
        )
    }

    private fun updateProgressTable(content: String, stats: ProblemStats): String {
        // Update the overall progress line
        val progressRegex = """\*\*🎯 Overall Progress: \d+/\d+ \(\d+%\)\*\*""".toRegex()
        val newProgress = "**🎯 Overall Progress: ${stats.completed}/${stats.total} (${
            String.format(
                "%.0f",
                stats.completionRate
            )
        }%)**"

        return content.replace(progressRegex, newProgress)
    }

    private fun executeCommand(command: String): CommandResult {
        return try {
            val process = ProcessBuilder(*command.split(" ").toTypedArray())
                .redirectErrorStream(true)
                .start()

            val output = process.inputStream.bufferedReader().readText()
            val exitCode = process.waitFor()

            CommandResult(exitCode, output, "")
        } catch (e: Exception) {
            CommandResult(1, "", e.message ?: "Unknown error")
        }
    }

    private fun openInIDE(filePath: String) {
        val ideCommands = listOf(
            "idea $filePath",           // IntelliJ IDEA
            "code $filePath",           // VS Code
            "subl $filePath",           // Sublime Text
            "atom $filePath"            // Atom
        )

        for (command in ideCommands) {
            try {
                Runtime.getRuntime().exec(command)
                break
            } catch (e: Exception) {
                // Try next IDE
            }
        }
    }

    private fun printHelp() {
        println("${BOLD}LeetCode CLI Tool - Commands:${RESET}")
        println()
        println("${GREEN}📝 Problem Management:${RESET}")
        println("  ${CYAN}create <num> <name> <category> [difficulty]${RESET} - Create new problem")
        println("  ${CYAN}complete <num> [message]${RESET}                   - Complete workflow")
        println()
        println("${GREEN}🧪 Testing & Validation:${RESET}")
        println("  ${CYAN}test [problem_num]${RESET}                        - Run tests")
        println()
        println("${GREEN}📤 Git Integration:${RESET}")
        println("  ${CYAN}commit <num> [message]${RESET}                    - Commit solution")
        println("  ${CYAN}push${RESET}                                      - Push to GitHub")
        println()
        println("${GREEN}📊 Progress Tracking:${RESET}")
        println("  ${CYAN}stats${RESET}                                     - Show statistics")
        println("  ${CYAN}update${RESET}                                    - Update progress")
        println()
        println("${GREEN}ℹ️  Information:${RESET}")
        println("  ${CYAN}help${RESET}                                      - Show this help")
        println("  ${CYAN}version${RESET}                                   - Show version")
        println()
        println("${YELLOW}💡 Examples:${RESET}")
        println("  leetcode create 001 TwoSum arrays easy")
        println("  leetcode test 001")
        println("  leetcode complete 001 \"Optimal HashMap solution\"")
        println("  leetcode stats")
    }

    private fun printVersion() {
        println("${BOLD}LeetCode CLI Tool v$VERSION${RESET}")
        println("${BLUE}🔗 Repository: $GITHUB_REPO${RESET}")
        println("${GREEN}✨ Professional workflow automation for LeetCode${RESET}")
    }

    data class ProblemStats(
        val completed: Int,
        val total: Int,
        val completionRate: Double,
        val byCategory: Map<String, Int>,
        val byDifficulty: Map<String, Int>
    )

    data class CommandResult(
        val exitCode: Int,
        val output: String,
        val error: String
    )
}

fun main(args: Array<String>) {
    LeetCodeCLI().main(args)
}