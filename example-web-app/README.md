# PE II WS20/21: Skeleton Project

> This repository contains example projects for a RESTful API with Spring Boot (`api/`) and for a single page application with Vue.js (`frontend/`).
> Please refer to the `README.md` files in the respective folders for concrete instructions.

## Quickstart

Assuming all prerequisites are fulfilled, you can follow these instructions to get to know the application:
- Start the API by navigating into its folder and executing `./mvnw spring-boot:run`.
- Open http://localhost:8080/api/v1/projects in your browser. It will show all available projects in the system.
- While executing REST Requests, dont´t use 'Postman'
- Use the same request with registrations and students, to show all of them. (e.g: http://localhost:8080/api/v1/registrations )
- Open http://localhost:8080/api/v1/(PROJECTS OR REGISTRATIONS OR STUDENTS)/1 in your browser. It will show the wanted object with ID `1`.
- Open http://localhost:8080/api/v1/(PROJECTS OR REGISTRATIONS OR STUDENTS)/42 in your browser. It will show a `404 Not found` error because there is no object of the wanted class with ID `42` in the system.
- Now start the frontend by navigating into its folder and executing `npm install` and then `npm run serve`.
- It will host the UI at http://localhost:8000, which you can now also open in your browser.
- Create new registrations at http://localhost:8000/#/registrations2, therefor type your groupmembers and the projects (sorted by preference) in the fields and submit the button.
- Look at all registrations, with all attributes a registration can have: http://localhost:8000/#/registrations . 
- Navigate to the projects view by clicking on the respective link or via the direct ULR http://localhost:8000/#/projects.
- Delete a project. Then confirm its deletion via the API by opening http://localhost:8080/api/v1/projects in your browser again.
