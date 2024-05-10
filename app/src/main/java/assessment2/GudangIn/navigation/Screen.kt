package assessment2.GudangIn.navigation

import assessment2.GudangIn.ui.screen.KEY_ID_STORAGE

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_STORAGE}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}