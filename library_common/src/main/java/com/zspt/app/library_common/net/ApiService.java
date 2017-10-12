package com.zspt.app.library_common.net;


/**
 * Created by yuequan on 2017/10/9.
 */

public class ApiService {

    private ApiService(){}
    private static class SingletonHolder{
        private static final ApiService INSTANCE=new ApiService();
    }
    public static ApiService getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public <S> S initService(Class<S> service) {
//        if (service.equals(HotA.class)) {
//            return NetManager.getInstance().create(service);
//        } else {
//
//        }
        return null;
    }

}
