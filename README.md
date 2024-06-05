﻿# Viewmodel-State-Handle
A simple app that shows the various ways to save data in SavedStateHandle


Viewmodel can handle configuration changes such as screen rotation but won't be able to handle system initiated process death.

It can be used to save progress or input in text fields.
eg: Storing most recent search query.

Can be retieved by LiveData, Stateflow, Compose state APIs.

Reference: https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-savedstate
