# Uncle Blob
A ready to use and lightweight storage server built with love using Java. The name is pun and refference to uncle bob the author of The Clean Code book and the word `blob` just refferes to a `Binary Large Object` in the java script world.

[Check out docker image on Github Pacckages](https://github.com/Tadiwr/uncle-blob/pkgs/container/uncle-blob-server)
[Checkout out docker image for Uncle Blob Client]()

![image](https://github.com/user-attachments/assets/d56c5397-312d-4788-ad1a-d895f6dc76ce)


The inspiration behind uncle blob was to avoid having to create storage server for every single project. Uncle blob is distributed as a docker image that you can easily pull and run on your machine with minimal configuration

Uncle blob also comes with a frontend ui made using Vue which allows you to visualise the files stored by the storage server. Here is a diagram to illustrate how it works

![image](https://github.com/user-attachments/assets/f9f103d3-e657-4dbd-8cc5-25cb836ff135)

The server is made up of three layers:
- the storage layer resonsable for writing, reading and deleting files on the disk
- the service layer responsible for the business logic of handling file uploads, downloads, overwrites and deletions
- the api layer provides a rest api to allow clients to interact with the server
