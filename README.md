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

MVVM (Model-View-ViewModel) architectural structure was used in the project. This approach is a design pattern used to separate user interface (UI) logic from business logic and data manipulation.

One of the smart ways of developing modern applications is by using MVVM, which encourages the separation of concerns and maintenance of code. Also, developersAndroid recommends using it when working on projects created with Jetpack compose.

   
<table>
  <tr>
   <td><strong>Components</strong>
   </td>
   <td><strong>What was its purpose?</strong>
   </td>
   <td><strong>Classes</strong>
   </td>
  </tr>
  <tr>
   <td>Model</td>
   <td>The app's data and business logic are represented in here. Data fetching and storage could be handled using data classes, databases, network APIs, or repositories.</td>
   <td><code>Repository</code><br>
   <code>Datasource</code><br>
    <code>Member</code><br>
   </td>
  </tr>
  <tr>
   <td>View</td>
   <td>The app's user interface is represented by the View. The View is in charge of rendering the user interface and receiving user input events.<br>
   </td>
   <td><code>MembersScreen</code><br>
   </td>
  </tr>
  <tr>
   <td>ViewModel</td>
   <td>Between the Model and the View, the ViewModel serves as a bridge. It contains the data to display in the View and provides methods to which the View can be used. It also interacts with the model to retrieve or update data. ViewModel has no direct reference to View, but View has.</td>
   <td><code>MembersScreenViewModel</code></td>
  </tr>
</table>
<br></br>

### Data

![Data Layer](https://user-images.githubusercontent.com/53402156/231830986-326d59a1-9558-4081-bf62-1266b8a2f70a.png)

There are repositories in the data layer. Depending on the type of data that handled, these repositories may have a single data source, several sources, or no sources at all.

Repositories' responsibilities are exposing data to the rest of the application, centralizing data changes, resolving conflicts between (if any) various data sources, separating data sources from the app  and containing business logic.

>Other layers should never access data sources directly; the entry points to the data layer are always the repository classes. State holder classes (see the UI layer guide) or use case classes (see the domain layer guide) should never have a data source as a direct dependency. Using repository classes as entry points allows the different layers of the architecture to scale independently.

In this project, member data is stored in a class called Datasource. Repository takes Datasource as dependency in its constructor. And it acts as a bridge between MembersScreenViewModel and Datasource. MembersScreenViewModel only receives the data it requires with this structure. It doesn't care from where or how the data was comes from for ViewModel. Because this is not ViewModel's responsibility.
<br></br>

### UI

![UI Layer](https://user-images.githubusercontent.com/53402156/231838477-f4153bf4-4a37-4747-9c93-edb5e5ff9911.png)

The UI's role is to display application data on the screen.
 
Any changes to the data must be reflected in the UI. The pipeline that converts application data changes into a form the UI can show and then displays them is known as the UI layer.

The tasks of the ui layer in developer.android are explained as follows:

>The role of the data layer is to hold, manage, and provide access to the app data, the UI layer must perform the following steps:
>- Consume app data and transform it into data the UI can easily render.
>- Consume UI-renderable data and transform it into UI elements for presentation to the user.
>- Consume user input events from those assembled UI elements and reflect their effects in the UI data as needed.
>- Repeat steps 1 through 3 for as long as necessary.

The project was created taking into account these items. In MembersScreenViewModel, the data from the Repository has been transformed into data that can be displayed in the UI using StateFlow and making the necessary transformations.

![Group 13](https://user-images.githubusercontent.com/53402156/231847442-531f3c6f-9b11-4414-aa89-3255abb3bb3d.png)

The events that occur when the user adds a new member to the list are as follows:
1. asd
2. asd
3. asd
4. asd
5. asd
6. asd
7. asd

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
