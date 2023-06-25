# ShortenGamemode
[![spigot](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/supported/spigot_vector.svg)](https://www.spigotmc.org/resources/shortengamemode.110736/)
[![paper](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/supported/paper_vector.svg)](https://forums.papermc.io/threads/shortengamemode.812/)
## Why does this plugin exist?
This plugin exists, because I couldn't find a small and lightweight plugin to do this.

## What versions does this plugin support?
 - Paper 1.13 - 1.20
 - Spigot 1.13 - 1.20

## What is the functionality of this plugin?
The plugin aims to be simple in use, while being very customizable. It's features include:

Just take a look at the config and messages file:  
<details>
<summary>messages.yml</summary>

```yaml
prefix: "&3&l[SG] "
not-enough-args-or-too-many-console: "&cNot enough args or too many!\nUsage: /{0} <survival/creative/adventure/spectator/0/1/2/3> <player name>" # {0} being the command run. Can be skipped.
not-enough-args-or-too-many: "&cInvalid command!\nUsage: /{0} <survival/creative/adventure/spectator/0/1/2/3> [player name]" # {0} being the command run. Can be skipped
no-permission: "&cYou don't have the necessary permission node to execute this command!"
player-offline: "&cThis player is offline!"
no-gamemode-permission: "&cYou don't have the permission to change your gamemode to {0} mode!" # {0} is the gamemode. Can be skipped
change-notify: "&2Your gamemode has been changed to {0} by {1}" # {0} is the gamemode, {1} is the person who did it. Can be skipped[Spigot](https://www.spigotmc.org/resources/shortengamemode.110736/)
change-success: "&2You have changed {1}'s gamemode to {0} ." # {0} is the gamemode, {1} is the person you changed the gamemode. Can be skipped
your-change-success: "&2You have changed your gamemode to {0} mode." # {0} is the gamemode. Can be skipped
change-notify-console: "&2Your gamemode has been changed to {0} mode." # {0} is the gamemode. Can be skipped
survival: "survival"
creative: "creative"
adventure: "adventure"
spectator: "spectator"
```

</details>
<details>
<summary>config.yml</summary>

```yaml
enable-permissions: true # This is a boolean! Can be false or true
permission-node: pl.majlitech.admin.gamemode
enable-specific-gamemode-permissions: true # This is (also) a boolean! Can be false or true
permission-node-survival: pl.majlitech.admin.gamemode.survival
permission-node-creative: pl.majlitech.admin.gamemode.creative
permission-node-adventure: pl.majlitech.admin.gamemode.adventure
permission-node-spectator: pl.majlitech.admin.gamemode.spectator
```

</details>

## I am convinced. How to install it on my server?
There are multiple ways to do so.
1. Stable
    - If you want a stable build of the plugin, download it from GitHub Releases.
2. Dev
    - If you would like to try new features, download artifacts from Actions. 

