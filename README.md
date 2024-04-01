Sample showing how to handle events, like button clicks, on interface in Compose using a UiEvent Class and passing only OnEvent parameter on Composable functions to avoid a long list of event calls on each composable.

Instead of: 

    @composable
    fun ComposeComponent(
        onButtonOneClicked: () -> Unit,
        onButtonTwoClicked: () -> Unit,
        onButtonThreeClicked: () -> Unit,
    ) {
    }

Collect all events together with onEvent:

    @composable
    fun ComposeComponent(
        onEvent: (UiEvent) -> Unit
    ) {
    }

And handle them in the viewModel:

    fun onEvent(event: UiEvent) {
        when(event) {
            // Handle each event here
        }
    }
