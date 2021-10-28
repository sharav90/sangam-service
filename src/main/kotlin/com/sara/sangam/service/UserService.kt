package com.sara.sangam.service

import com.sara.sangam.dto.UserProfileDto

interface UserService {
    /**
     * This method used for create a new user.
     * @param userDto - user information
     * @return UserProfileDto
     */
    fun createUser(userDto: UserProfileDto): UserProfileDto

    /**
     * This method used for get all User information.
     */
    fun findAll(): List<UserProfileDto>

    /**
     * This method used for edit/update the user information
     * @param userDto - edit/update user information
     * @return UserProfileDto
     */
    fun updateUser(userDto: UserProfileDto): UserProfileDto

    /**
     * This method used for get User by userId.
     * @param userId
     * @return UserProfileDto
     */
    fun findByUserId(userId: Int): UserProfileDto

    /**
     *This method used for delete user based on userId.
     * @param userId
     * @return delete operation message
     */
    fun deleteByUserId(userId: Int): String
}