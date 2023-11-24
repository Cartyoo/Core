# Core
What is core?
Core is a Minecraft plugin that contains basic features and commands for servers.

# Q & A
Question: How do I download and install Core on my server?
Answer: Download the latest file from the "releases" tab, put it in your /plugins folder on your server, then restart your server!

# Compatability
Core is currently only tested on the latest version of Minecraft (1.20.2). Core may still work on outdated versions down to 1.17.1 (NOT GUARENTEED OR TESTED)

# Commands
- /gmc <player>
- /gms <player>
- /gmsp <player>
- /gma <player>
- /gamemode <gamemode> [player]
- /fly <player>

# Other (Events/Listeners)
- Join & Leave Messages

# Why choose Core?
- Core is fully configurable via ONE file; change every message, prefix, and more in the config YAML file.
- Support; add herbert__ on Discord for support for Core related issues.
- Open-Source; Core is open source! You can contribute via GitHub, view Core's code, and compile for yourself!

*speaking of compilation...*
# How to compile
You can compile Core as a JAR file to use in your Minecraft server by:
1. Download all the code
2. Download Gradle (https://gradle.org/install/)
3. Open your terminal
4. For Ubuntu Users only, do `sudo chmod -R 777 ./gradlew`
5. For Ubuntu Users only, do `./gradlew shadowJar`
6. For Windows users, do `gradlew.bat shadowJar` (UNTESTED)
7. Find the JAR file named `Core-1.0-SNAPSHOT-all.jar` in `/build/libs`, then put it in your `/plugins` folder on your server.
8. Restart

# Other
If you have any suggestions, feel free to contribute!
