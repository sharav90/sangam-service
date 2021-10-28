package com.sara.sangam.service

import com.sara.sangam.dto.UserProfileDto
import com.sara.sangam.entity.UserProfile
import com.sara.sangam.repository.UserProfileRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    @Autowired
    private lateinit var repository: UserProfileRepository

    override fun createUser(userDto: UserProfileDto): UserProfileDto {
        return toDto(repository.save(toEntity(userDto)))
    }

    override fun findAll(): List<UserProfileDto> {
        val users = repository.findAll()
        var usersDto = mutableListOf<UserProfileDto>()
        users.forEach { usersDto.add(toDto(it)) }
        return usersDto
    }

    override fun updateUser(userDto: UserProfileDto): UserProfileDto {
        var user = toEntity(userDto)
        user = repository.save(user)
        return toDto(user)
    }

    override fun findByUserId(userId: Int): UserProfileDto {
        return toDto(repository.findByUserId(userId))
    }

    override fun deleteByUserId(userId: Int): String {
        repository.deleteByUserId(userId)
        return "User deleted successfully"
    }

    private fun toDto(user: UserProfile): UserProfileDto {
        val dto = UserProfileDto()
        BeanUtils.copyProperties(user, dto)
        return dto
    }

    private fun toEntity(dto: UserProfileDto): UserProfile {
        val user = UserProfile()
        BeanUtils.copyProperties(dto, user)
        return user
    }
}