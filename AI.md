# AI Usage

1. Use Copilot to generate commit messages
    - Seems to follow past commit messages style
    - Half of the time doesn't really understand what I'm doing.
2. Use Copilot for code completion
    - Can understand the context of the code and provide useful suggestions, including error handling.
    - Only a comment or a few lines of code are needed, Copilot can infer what you want to do.
    - However, manual adjustments such as output formatting are needed.
3. Use Copilot for JavaDoc
    - Super useful and accurate, with details that as a human is quite tedious to write.
    - Sometimes too much details.
    - Sometimes will be completely wrong, but is very rare.
4. Use Copilot (Chat) for Refactoring to include Enums (Tag A-Enums).
    - The main idea is there, but a lot of tiny details are wrong. Basically the whole code needs to be checked again.
    - For example, in a commit a change was used to make a "task" variable a static class member,
        however the refactored code did not reflect this change.
    - The list command was completely removed during the refactoring.
    - The use of exceptions is also not consistent. Therefore, I have created a new UnexpectedException type.
    - Still heavily unreliable and needs a lot of manual work (~15 minutes after first prompt to refactor).
5. Just found out about Copilot Edits.
    - Given a prompt (refactor so that it splits into Ui, Storage, Parser, and TaskList classes), Copilot Edits will automatically create the files for you.
    - Some problems encountered include:
        - File stored in the wrong directory
        - Imports are wrong (did not import the right packages)
        - Types are wrong
        - Missing features when refactoring (e.g. missing methods, error handling)
    - Saved *a lot* of time, but still needs quite a lot of manual adjustments/reprompts.