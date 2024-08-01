package uz.ssh.newsapp.domain.usercases.app_entry

import kotlinx.coroutines.flow.Flow
import uz.ssh.newsapp.domain.manager.LocalUserManager

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> = localUserManager.readAppEntry()

}