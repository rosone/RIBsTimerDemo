package com.gogovan.data;

import com.gogovan.data.dao.TimeTaskDao;
import com.gogovan.data.entities.TimeTaskEntity;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;


/**
 * 定义一个仓库类，避免直接操作本地数据库
 * Created by Arthur on 2018/11/10.
 */
public class TimeTasksRepository {

    private final TimeTaskDao mTimeTaskDao;

    public TimeTasksRepository(TimeTaskDao mTimeTaskDao) {
        this.mTimeTaskDao = mTimeTaskDao;
    }


    /**
     * 插入记录
     * @param taskEntity
     * @return
     */
    public Observable<Boolean> saveTimeTask(final TimeTaskEntity taskEntity) {

     return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                mTimeTaskDao.insertAll(taskEntity);
                emitter.onNext(true);

                emitter.onComplete();

            }
        }).subscribeOn(Schedulers.io());

    }

    public Maybe<List<TimeTaskEntity>> getAllTask() {

        return mTimeTaskDao.getAll().subscribeOn(Schedulers.io());
    }
}