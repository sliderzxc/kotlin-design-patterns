package patterns.state

/**
 * Represents the various authorization states using the State Pattern.
 */
sealed class AuthorizationState

/**
 * Represents the unauthorized state. It is a singleton object.
 */
object Unauthorized : AuthorizationState()

/**
 * Represents the authorized state with a user name.
 * @property userName The user name associated with the authorized state.
 */
class Authorized(val userName: String) : AuthorizationState()

/**
 * Manages the authorization state using the State Pattern.
 * The class handles the transition between different authorization states and provides information
 * about the current authorization status and user name.
 */
class AuthorizationPresenter {

    // Initial state is Unauthorized
    private var state: AuthorizationState = Unauthorized

    /**
     * Gets the authorization status.
     * @return `true` if the user is authorized, `false` otherwise.
     */
    val isAuthorized: Boolean
        get() = when (state) {
            is Authorized -> true
            is Unauthorized -> false
        }

    /**
     * Gets the user name associated with the current authorization state.
     * @return The user name if authorized, otherwise "Unknown".
     */
    val userName: String
        get() {
            return when (val currentState = this.state) {
                is Authorized -> currentState.userName
                is Unauthorized -> "Unknown"
            }
        }

    /**
     * Logs in a user and changes the state to Authorized.
     * @param userName The user name to be associated with the authorized state.
     */
    fun loginUser(userName: String) {
        state = Authorized(userName)
    }

    /**
     * Logs out a user and changes the state to Unauthorized.
     */
    fun logoutUser() {
        state = Unauthorized
    }

    /**
     * Provides a readable representation of the AuthorizationPresenter object.
     * @return A string indicating the user's login status and user name.
     */
    override fun toString() = "User '$userName' is logged in: $isAuthorized"
}

/**
 * Main function demonstrating the usage of the State Pattern with different authorization states.
 */
fun main() {
    // Create an instance of AuthorizationPresenter
    val authorizationPresenter = AuthorizationPresenter()

    // Login user, print the presenter state, and display authorization status and user name
    authorizationPresenter.loginUser("admin")
    println(authorizationPresenter)
    println("Is authorized: ${authorizationPresenter.isAuthorized}")
    println("User name: ${authorizationPresenter.userName}")

    // Logout user, print the presenter state, and display authorization status and user name
    authorizationPresenter.logoutUser()
    println(authorizationPresenter)
    println("Is authorized: ${authorizationPresenter.isAuthorized}")
    println("User name: ${authorizationPresenter.userName}")
}
