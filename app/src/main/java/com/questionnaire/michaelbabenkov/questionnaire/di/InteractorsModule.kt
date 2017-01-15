package com.questionnaire.michaelbabenkov.questionnaire.di

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.ResolveSubmitStatusInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.SubmitPointsInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.impl.ResolveSubmitStatusInteractorImpl
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.impl.SubmitPointsInteractorImpl
import uy.kohesive.injekt.api.InjektModule
import uy.kohesive.injekt.api.InjektRegistrar
import uy.kohesive.injekt.api.addSingletonFactory

/**
 * Created by michael.babenkov on 9/01/17.
 */
object InteractorsModule : InjektModule {

    override fun InjektRegistrar.registerInjectables() {
        addSingletonFactory<ResolveSubmitStatusInteractor> { ResolveSubmitStatusInteractorImpl() }
        addSingletonFactory<SubmitPointsInteractor> { SubmitPointsInteractorImpl() }
//        addSingletonFactory<RegisterDeviceInteractor> { RegisterDeviceInteractorImpl() }
//        addSingletonFactory<UpdateFcmTokenInteractor> { UpdateFcmTokenInteractorImpl() }
//        addSingletonFactory<GetGroupsInteractor> { GetGroupsInteractorImpl() }
//        addSingletonFactory<GetUserInfoInteractor> { GetUserInfoInteractorImpl() }
//        addSingletonFactory<UpdateProfileInteractor> { UpdateProfileInteractorImpl() }
//        addSingletonFactory<GetContactsInteractor> { GetContactsInteractorImpl() }
//        addSingletonFactory<SearchContactsInteractor> { SearchContactsInteractorImpl() }
//        addSingletonFactory<LikePostInteractor> { LikePostInteractorImpl() }
//        addSingletonFactory<GetCommentsInteractor> { GetCommentsInteractorImpl() }
//        addSingletonFactory<CreateCommentInteractor> { CreateCommentInteractorImpl() }
//        addSingletonFactory<DeleteCommentInteractor> { DeleteCommentInteractorImpl() }
//        addSingletonFactory<LogoutInteractor> { LogoutInteractorImpl() }
//        addSingletonFactory<GetFeedbackSubjectsInteractor> { GetFeedbackSubjectsInteractorImpl() }
//        addSingletonFactory<SendFeedbackInteractor> { SendFeedbackInteractorImpl() }
//        addSingletonFactory<ForgotPasswordInteractor> { ForgotPasswordInteractorImpl() }
//        addSingletonFactory<DownloadFileInteractor> { DownloadFileInteractorImpl() }
//        addSingletonFactory<CreateDiscussionInteractor> { CreateDiscussionInteractorImpl() }
//        addSingletonFactory<DeleteDiscussionInteractor> { DeleteDiscussionInteractorImpl() }
//        addSingletonFactory<UpdateDiscussionInteractor> { UpdateDiscussionInteractorImpl() }
//        addSingletonFactory<GetPostsUpdateInteractor> { GetPostsUpdateInteractorImpl() }
//        addSingletonFactory { NetworkCheckInteractor()}
//
//        //cannot be singleton due to sharing it with multiple alive fragments
//        addFactory(typeRef<GetPostsInteractor>(), { GetPostsInteractorImpl()})
//        addFactory(typeRef<GetFilesInteractor>(), { GetFilesInteractorImpl()})
    }
}