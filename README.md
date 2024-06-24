# OpenLMIS Implementation Documentation

## Table of Contents
1. Installation
2. Configuration
3. Running the Project
4. Additional Resources

## 1.Installation

### Docker Installation
First, Docker was installed on Ubuntu following the instructions provided here.

### Cloning the OpenLMIS Repository
The OpenLMIS repository (version v3.17.0) was cloned from GitHub:
```bash
git clone https://github.com/OpenLMIS/openlmis-ref-distro.git
```
## 2. Configuration
### Editing the Docker Compose Files
The version line was deleted from both docker-compose.yml and docker-compose.override.yml.

### Editing the settings.env File
The settings.env file was edited to include the line spring_profiles_active=demo-data. This ensures that when you run docker compose up, demo data is loaded into the project database.

### Updating the FTP Image
The FTP image in docker-compose.yml was updated to stilliard/pure-ftpd because the old one had an outdated manifest.

## 3. Running the Project
To run the project using demo data, navigate to the project directory and run:
```bash 
docker compose up
```
 then visit http://VM_OS_IP
## 4. Additional Resources
For more information, check out the official OpenLMIS Technical Setup Guide.(https://openlmis.atlassian.net/wiki/spaces/OP/pages/115681666/OpenLMIS+Technical+Setup+Guide)

