# Core
What is core?
Core is a Minecraft plugin that contains basic features and commands for servers.

# Q & A
Question: How do I download and install Core on my server?
Answer: Download the latest file from the "releases" tab, put it in your /plugins folder on your server, then restart your server!

# Compatability
Core is currently only tested on the latest version of Minecraft (1.20.2). Core may still work on outdated versions down to 1.17.1

# Setup
Some things in Core need extra setup, please refer to https://github.com/Cartyoo/Core/blob/main/SETUP.MD

# Commands
- /gmc [player]
- /gms [player]
- /gmsp [player]
- /gma [player]
- /gamemode|/gm <gamemode> [player]
- /fly|/f [player]
- /setspawn
- /spawn [player]
- /warp <warpname>
- /setwarp|/createwarp <warpName>
- /deletewarp|/delwarp <warpName>
- /weather <weather>
- /sun
- /thunder|/lightning
- /rain|/storm
- /clearchat|/cc
- /heal [player]
- /renameitem|/itemrename|/rename <string>
- /clear|/clearinventory|/ci [player]
- /list
- /trash|/bin|/disposal
- /ping [player]
- /skull [player]
- /feed [player]
- /hat|/helmet
- 

# Other (Events/Listeners)
- Join & Leave Messages
- Chat Format

# Why choose Core?
- Core is fully configurable via ONE file; change every message, prefix, and more in the config YAML file.
- Support; add herbert__ on Discord for support for Core related issues.
- Open-Source; Core is open source! You can contribute via GitHub, view Core's code, and compile for yourself!

# Contributions
If you have any suggestions, feel free to contribute!

# TODO
- Add seperate permissions for commands that have a target. Example `/fly doebert` will have the permission `core.command.fly.others` while `/fly` will only require `core.command.fly`
