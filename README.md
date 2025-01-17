# MaidChan project template

This is a project template for a greenfield Java project. It's inspired after the AI program in the anime "Sakurasou no Pet na Kanojo", Maid-chan.
Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
1. Open the project into Intellij as follows:
   1. Click `Open`.
   1. Select the project directory, and click `OK`.
   1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 17** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/MainChan.java` file, right-click it, and choose `Run MaidChan.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
   Hello from
    __  __       _     _  ____ _
   |  \/  | __ _(_) __| |/ ___| |__   __ _ _ __
   | |\/| |/ _` | |/ _` | |   | '_ \ / _` | '_ \
   | |  | | (_| | | (_| | |___| | | | (_| | | | |
   |_|  |_|\__,_|_|\__,_|\____|_| |_|\__,_|_| |_|
   ```

Ascii Art Generated Using: https://www.asciiart.eu/text-to-ascii-art
**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.
