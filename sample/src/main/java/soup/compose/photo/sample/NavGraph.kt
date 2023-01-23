package soup.compose.photo.sample

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

data class Destination(
    val key: String,
    val description: String,
    val content: @Composable (NavBackStackEntry) -> Unit
) {
    companion object {
        val all: List<Destination> = listOf(
            Destination(
                key = "PhotoBox",
                description = "PhotoBoxDemo",
                content = {
                    PhotoBoxDemo()
                }
            ),
            Destination(
                key = "PhotoBox in Pager",
                description = "PhotoBoxInPagerDemo",
                content = {
                    PhotoBoxInPagerDemo()
                }
            ),
            Destination(
                key = "PhotoBox with Coil",
                description = "PhotoBoxWithCoilDemo",
                content = {
                    PhotoBoxWithCoilDemo()
                }
            ),
        )
    }
}

@Composable
fun NavGraph() {
    val destinations = Destination.all
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                destinations,
                onItemClick = {
                    navController.navigate(it.key)
                }
            )
        }

        destinations.forEach { destination ->
            composable(destination.key) {
                destination.content(it)
            }
        }
    }
}
