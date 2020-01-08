package com.aungmyolwin.splasher.domain.photos

import androidx.lifecycle.LiveData
import com.aungmyolwin.splasher.BuildConfig
import com.aungmyolwin.splasher.data.photos.PhotoRepositoryImpl
import com.aungmyolwin.splasher.vo.Photo
import com.aungmyolwin.splasher.vo.Result
import javax.inject.Inject

/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */
class LoadAllPhotoUseCase @Inject constructor(
        private val repository: PhotoRepositoryImpl
) {
    suspend fun execute(/*result: LiveData<Result<List<Photo>>>*/): LiveData<Result<List<Photo>>> {

        /*result.addSource(repository.getAllPhotos(BuildConfig.ACCESS_KEY)) {

            result.value = it
        }*/
        return repository.getAllPhotos(BuildConfig.ACCESS_KEY)

    }
}