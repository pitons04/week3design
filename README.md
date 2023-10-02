# week3design
CSC207 Week 3 Design Deliverables Group Project

## Problem Domain: 
Music, specifically organizing music found on Spotify

## Application we're thinking of developing:
An app that allows a user to create and organize Spotify playlists.
We want to offer to create playlists based on artists a user wants to include, genre, mood (i.e. happy, sad, etc.), 
adding/ deleting songs or entire artists/ genres
We want to offer organizing playlists with functions like merging playlists, separating by artist/ genre, 
randomizing playlist order.
We want to offer liking/disliking songs and display the likes/dislikes.
We want to record the frequency of times a song is listened to.
We want to offer merging playlists between users.

API Documentation link: https://developer.spotify.com/documentation/web-api

## Technical Issues:
We aren't able to actually make an API call inside of Java/ Intellij.
The compiler keeps preventing us from doing an API call because of a "deprecated method", but it doesn't say which method we used is causing the issue. Is there any way to find out what the deprecated method is?

## Screenshots of making a call on Postman:
![Screenshot of token generation](https://github.com/pitons04/week3design/blob/main/Screenshots/Postman%20Auth%2C%20Generating%20Token%20For%20Spotify%20API%20Screenshot%20Part%201%20-%20CSC207%20Group%20229%20.png)
![Screenshot of token generation pt.2](https://github.com/pitons04/week3design/blob/main/Screenshots/Postman%20Auth%2C%20Generating%20Token%20For%20Spotify%20API%20Screenshot%20Part%202%20-%20CSC207%20Group%20229%20.png)
![Screenshot of playlist creation](https://github.com/pitons04/week3design/blob/main/Screenshots/Creating%20A%20Playlist%20Through%20Spotify%20API%20With%20Postman%2C%20POST%20and%20Body%20Screenshot%20-%20CSC207%20Group%20229%20.png)
![Playlist creation result](https://github.com/pitons04/week3design/blob/main/Screenshots/Creating%20A%20Playlist%20Through%20Spotify%20API%20With%20Postman%2C%20POST%2C%20Params%20and%20Result%20Screenshot%20-%20CSC207%20Group%20229%20.png)
Screenshots of Trying Spotify API Through Postman are in the "Screenshots" folder of this git.
We generated an auth key to use Spotify. Then we made a POST request to create a playlist "CSC207 Playlist1" for user "eug."

## Java Function
Attempted to make an API call from Intellij using gradle as well as copying Lab 3 gradeapi, shown in Spotify.java. 
The goal of the gradle was to create a playlist and the goal of Spotify.java was to return an artist's album list.