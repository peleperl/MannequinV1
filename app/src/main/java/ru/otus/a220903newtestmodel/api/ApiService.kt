package ru.otus.a220903newtestmodel.api

import io.reactivex.Observable
import retrofit2.http.GET
import ru.otus.a220903newtestmodel.pojo.GlobalResponse
import ru.otus.a220903newtestmodel.pojo.SeparateUserResponse

interface ApiService {
    @GET("users.get?user_ids=sequan,232693573,95887282,anikkva,id360606928,id_shine_sky&fields=city,bdate,photo_100,photo_400_orig&access_token=vk1.a.wqsliom3m7IqL49t6WYxhnUPObmlSxGiugaVl7XiRBgqcMYsGywjeoEj7W_dKlSJZmVLbezruWETF_EAVLU9ANq0s1UI1huqo0rkYjM4OakslhgofeJ1c87O7qLaBphy1It8S3vwo0wSVENIrPtYkP-glmoVUEjSWjnVVg5NcSTvO7kD154axagqK-GQx9fx&expires_in=0&user_id=138267023&v=5.131")
    fun getMannequin(): Observable<SeparateUserResponse>

    @GET("friends.get?user_ids=peleperl&fields=first_name,last_name,photo_100,city,photo_200,bdate&access_token=vk1.a.wqsliom3m7IqL49t6WYxhnUPObmlSxGiugaVl7XiRBgqcMYsGywjeoEj7W_dKlSJZmVLbezruWETF_EAVLU9ANq0s1UI1huqo0rkYjM4OakslhgofeJ1c87O7qLaBphy1It8S3vwo0wSVENIrPtYkP-glmoVUEjSWjnVVg5NcSTvO7kD154axagqK-GQx9fx&expires_in=0&user_id=138267023&v=5.131")
    fun getMyFriends(): Observable<GlobalResponse>

}