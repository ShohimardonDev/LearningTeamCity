package uz.ssh.newsapp.presentation.onboarding

sealed class OnBoardEvent {
    object SaveAppEntry : OnBoardEvent()
}