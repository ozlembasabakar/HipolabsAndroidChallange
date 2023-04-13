# HipolabsAndroidChallange

This project was created for Hipo Android Summer Internship program. Built entirely with Jetpack Compose and Kotlin. 

The design of the app can be found [here](https://www.figma.com/file/4DLsGdSLVXG5ITS5wsBzIw/Android-Summer-Intern-Project?t=LGObl4eidrgaicFY-0).

## Architecture

Architecture may not seem necessary for relatively small scaled projects. However, when the project size is increased, the architecture will be highly needed. This will increase the **_sustainability_** and **_robustness_** of the application and **_make it easier to test_**.

Each part has a different responsibility when using the architecture in application. For example, the codes related to the fetching data and the screen showing this data should not be in the same place. Because the purposes of these two subjects are different. And their **concerns are also separate**.

Instead, a separate part must be created for the data to be used in the application. And this partition should be the **single source of the data**.

This means that the owner (_and single source_) of the data has the authority to _change_ and _mutate_ the data. Having these features ensures data protection by keeping changes in one place.

Keeping data in a single source also ensures **one-way(_unidirectional_) data flow**. 

>The single source of truth principle is often used in our guides with the Unidirectional Data Flow (UDF) pattern. In UDF, state flows in only one direction. The events that modify the data flow in the opposite direction.


### Data
### UI

## Screenshots
 
**MembersScreen**

![MembersScreen](https://user-images.githubusercontent.com/53402156/231798247-6e80dd3a-7738-4775-bd1f-81db52262a69.png)

**AddNewMemberDialogScreen**

![AddNewMemberScreen](https://user-images.githubusercontent.com/53402156/231798242-783f2aa9-913f-4065-a2e8-4e9fbb7cdef2.png)
![AddNewMemberScreen_error](https://user-images.githubusercontent.com/53402156/231797836-8dbf5faf-0619-4924-89cd-1e5908fbf9bf.png)

**MembersScreen After Added New Memeber**

![NewMemberAddedScreen](https://user-images.githubusercontent.com/53402156/231798240-d6b8ea55-b3bf-47d5-b78e-31d6393d52ef.png)

**Searching  After Added New Memeber**

![SearchAfterNewMemberAddedScreen](https://user-images.githubusercontent.com/53402156/231798236-ceeaefa4-c2b9-41ce-b9fe-fca64d83374b.png)
