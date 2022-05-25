# MinePyScript (WIP)

A Spigot/Bungeecord plugin to provide python scripting for Minecraft Servers

## Introduction

When working on minecraft servers, often there are things you'd like to do that require some level of scripting.

I often find myself wishing there was an easy way to work with my servers to implement QOL features or simple things that otherwise would be frustrating to implement in Java. Things that otherwise don't require the entire spigot API, but you would like simple, (read only?) access to. 

This project aims to be a solution to these problems.

## The Plan

I'd like to implement a simple Python HTTP server using Flask that can take HTTP requests from the plugin and handle them in different ways.

For example:
1. Spigot/Bungeecord server starts.
2. In the `onEnable` event for either, it makes an HTTP request to the Python server to trigger tasks that you would normally run in the `onEnable` section.
3. In the python server, it loads a set of user defined scripts. These scripts would be provided with a python library or pseudo API to format some pre-defined commands to execute on the main java server. (For example, registering a command or event handler). The python server then replies to the Java server with a list of these pre-defined commands to execute.
4. The main java server reads the reply and executes these commands, registering any nessecary event or command handlers.
5. Whenever the java server recieves one of these events or commands, it sends another HTTP request to the python server that will then handle that command by forwarding it to the user defined scripts.
6. Your handler is then allowed to execute a simple set of commands (like send the player a command reply or to cancel an event) that will be parsed by the python server.
7. The python server then forwards your handled event or command back to the Java server which will then execute whatever set of functions or commands you requested in your script.

## Challenges

- How do you execute a python webserver in a way that respects Bungeecord/Spigot's "non reloadable" nature (while it is possible to reload, it is strongly discouraged)
- How do you secure a system like this against potential attackers? (Likely some sort of key exchange should be made to ensure an attacker cannot intervene or run malicious code)
- What is the best way to implement object serialization for sending through HTTP? Which side should do the brunt of the processing?
- How do you distribute the Python library in an intelligent mannner that allows for easy development of scripts?
- If Spigot/Bungeecord changes, what is the easiest way to implement these changes to my scripts?
- By nature, python is dynamically typed whereas java is strictly typed. This could cause issues in conversion of objects from one language to another.

## Todo list

### Python
- [ ] Implement basic HTTP server in Flask
- [ ] Build class/file loading system for loading scripts
- [ ] Create interfaces for various spigot/bungee things (like chat colors)
- [ ] Work out a command structure for communicating with the Java Server

### Java
- [ ] Implement basic interfaces for command handler (Bungee)
- [x] Implement basic interface for event listeners (Bungee)
- [ ] Implement basic interfaces for command handler (Spigot)
- [ ] Implement basic interface for event listeners (Spigot)
- [ ] Build HTTP messaging system
- [ ] Build command parser from HTTP request responses
