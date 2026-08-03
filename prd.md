# GoalFund - Product Requirements Document (PRD)

Version: 1.0
Status: MVP
Architecture: Monolithic
Backend: Spring Boot
Database: MySQL
Authentication: JWT
Deployment: Docker Compose

---

# 1. Overview

GoalFund is a crowdfunding platform that enables users to create financial goals and allows other registered users to contribute toward those goals.

Unlike traditional personal finance applications, GoalFund focuses on community-powered financial assistance where every financial goal is publicly visible to all users.

The application is built as a monolithic Spring Boot REST API.

---

# 2. Problem Statement

Many individuals require financial support for personal goals such as:

- Education
- Medical expenses
- Travel
- Business startups
- Buying equipment
- Emergency funds

Current crowdfunding platforms are often complex and include payment gateway integrations, campaign verification, and social media features.

GoalFund aims to provide a simplified backend-focused crowdfunding platform for learning enterprise backend development.

---

# 3. Goals

The MVP should demonstrate:

- Secure Authentication using JWT
- RESTful API Design
- Entity Relationships
- Business Rules
- Aggregate Database Queries
- Transaction Management
- Dockerized Deployment
- Clean Architecture

---

# 4. Users

## Registered User

Can

- Register
- Login
- Create Goals
- Update own Goals
- Delete own Goals
- Browse all Goals
- Contribute to Goals
- View Contribution History
- View Dashboard

---

## Admin

Can

- View all users
- View all goals
- Delete inappropriate goals
- Deactivate users
- View platform statistics

---

# 5. Functional Requirements

## Authentication

### Register

A new user can register.

Required fields

- Name
- Email
- Password

Email must be unique.

Passwords are stored using BCrypt.

---

### Login

Users login using email and password.

A JWT token is generated upon successful login.

Protected endpoints require Authorization Bearer Token.

---

# User Module

Users can

- View profile
- Update profile
- View own dashboard

---

# Goal Module

Users can

- Create Goal
- View Goal
- Update own Goal
- Delete own Goal
- View all Goals

Each goal contains

- Title
- Description
- Category
- Target Amount
- Current Amount
- Deadline
- Status
- Owner

All goals are public.

---

# Contribution Module

Users can

- Contribute to another user's goal
- View contribution history
- View contributors of a goal

Each contribution records

- Contributor
- Goal
- Amount
- Timestamp

---

# Dashboard Module

Dashboard displays

My Goals

Goals I Supported

Total Contributions Made

Total Amount Received

Completed Goals

Active Goals

Expired Goals

---

# Admin Module

Admin dashboard displays

Total Users

Total Goals

Completed Goals

Expired Goals

Total Contributions

Most Funded Goals

Top Contributors

---

# 6. Non Functional Requirements

- Stateless Authentication
- Layered Architecture
- DTO Pattern
- Global Exception Handling
- Validation
- Pagination
- Sorting
- Logging
- Docker Support

---

# 7. Database Design

## User

| Field | Type |
|---------|------|
| id | Long |
| name | String |
| email | String |
| password | String |
| role | Enum |
| createdAt | Timestamp |

---

## Goal

| Field | Type |
|---------|------|
| id | Long |
| title | String |
| description | Text |
| category | Enum |
| targetAmount | Decimal |
| currentAmount | Decimal |
| deadline | Date |
| status | Enum |
| owner | User |
| createdAt | Timestamp |

---

## Contribution

| Field | Type |
|---------|------|
| id | Long |
| amount | Decimal |
| contributedAt | Timestamp |
| contributor | User |
| goal | Goal |

---

# 8. Entity Relationships

User

1 ---- * Goal

User

1 ---- * Contribution

Goal

1 ---- * Contribution

---

# 9. Goal Status

ACTIVE

COMPLETED

EXPIRED

---

# 10. Business Rules

Users cannot contribute to their own goals.

Users cannot contribute negative amounts.

Contribution amount must be greater than zero.

Completed goals cannot receive contributions.

Expired goals cannot receive contributions.

Current amount cannot exceed target amount.

Only goal owner can update or delete goal.

Goal automatically becomes COMPLETED once target amount is reached.

Goal automatically becomes EXPIRED after deadline.

---

# 11. Aggregate Requirements

The system shall support

Total Amount Raised Per Goal

Total Amount Raised By User

Average Contribution

Largest Contribution

Number of Contributors Per Goal

Top Funded Goals

Goals By Category

Total Contributions On Platform

Top Contributors

Completion Percentage

---

# 12. REST API Overview

Authentication

POST /auth/register

POST /auth/login

---

Users

GET /users/me

PUT /users/me

---

Goals

POST /goals

GET /goals

GET /goals/{id}

PUT /goals/{id}

DELETE /goals/{id}

GET /goals/search

---

Contributions

POST /goals/{id}/contribute

GET /goals/{id}/contributors

GET /users/me/contributions

---

Admin

GET /admin/dashboard

GET /admin/users

GET /admin/goals

DELETE /admin/goals/{id}

---

# 13. Security

Spring Security

JWT Authentication

BCrypt Password Encoding

Role Based Authorization

Stateless Sessions

---

# 14. Docker Deployment

Docker Compose includes

- Spring Boot Application
- MySQL Database

Containers communicate through Docker Network.

---

# 15. Future Enhancements

Comments

Likes

Bookmarks

Goal Updates

Notifications

Email Verification

Payment Gateway

Image Upload

Leaderboard

Achievement Badges

Goal Sharing

Scheduled Expiry Jobs

Analytics Dashboard