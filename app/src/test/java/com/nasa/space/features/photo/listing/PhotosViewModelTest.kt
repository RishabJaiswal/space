package com.nasa.space.features.photo.listing

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nasa.space.common.Loading
import com.nasa.space.common.Result
import com.nasa.space.common.Success
import com.nasa.space.features.photo.common.data.Photo
import com.nasa.space.features.photo.common.data.PhotoRepository
import com.nasa.space.features.photo.common.data.Photos
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.*
import org.junit.rules.TestRule
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class PhotosViewModelTest {

    private lateinit var photosViewModel: PhotosViewModel
    private val photos: Photos by lazy {
        arrayListOf(
            Photo(title = "Photo1"),
            Photo(title = "Photo2"),
        )
    }

    @Mock
    private lateinit var photoRepository: PhotoRepository

    @Mock
    private lateinit var observer: Observer<Result<Photos>>

    @Captor
    private lateinit var argumentCaptor: ArgumentCaptor<Result<Photos>>

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        photosViewModel = PhotosViewModel(photoRepository)
        photosViewModel.photosLiveResult.observeForever(observer)
    }

    @After
    fun tearDown() {
        photosViewModel.photosLiveResult.removeObserver(observer)
    }

    @Test
    fun `verify successful fetch of photos emits loading & success result states`() {
        //given
        `when`(photoRepository.getPhotos()).thenReturn(Single.just(photos))

        //when
        photosViewModel.getPhotos()

        //then
        verify(observer, times(3))
            .onChanged(argumentCaptor.capture())

        //assertions
        val resultStates = argumentCaptor.allValues
        assertThat(
            resultStates, `is`(
                listOf(
                    Loading(), Loading(), Success(photos)
                )
            )
        )
    }

    companion object {

        @BeforeClass
        @JvmStatic
        fun setupAll() {
            RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        }
    }
}