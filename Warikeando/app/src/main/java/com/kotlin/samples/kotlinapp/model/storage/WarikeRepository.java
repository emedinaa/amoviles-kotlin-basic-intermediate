package com.kotlin.samples.kotlinapp.model.storage;

import android.app.Application;
import android.os.AsyncTask;

import com.kotlin.samples.kotlinapp.model.entity.Warike;
import com.kotlin.samples.kotlinapp.model.storage.db.WarikeDao;
import com.kotlin.samples.kotlinapp.model.storage.db.WarikeDataBase;


import java.util.List;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 6/8/18
 */
public class WarikeRepository {

    private final WarikeDao noteDao;
    private List<Warike> notes;

    public WarikeRepository(Application application) {
        WarikeDataBase db = WarikeDataBase.getDatabase(application);
        noteDao = db.warikeDao();
    }

    public void getAllPlaces(QueryCallback queryCallback){
        //return notes = noteDao.getAll();
        /*new PopulateAsyncTask(noteDao, new PopulateCallback() {
            @Override
            public void onSuccess(List<NoteEntity> noteEntities) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        }).execute();*/
        new QueryAsyncTask(noteDao, queryCallback).execute();
    }

    public void addPlace(Warike warike){
        //noteDao.insert(noteEntity);
        new InsertAsyncTask(noteDao).execute(warike);
    }

    //asynctask
    private static class QueryAsyncTask extends AsyncTask<Void, Void, List<Warike>> {

        private final WarikeDao mAsyncTaskDao;
        private final QueryCallback queryCallback;

        QueryAsyncTask(WarikeDao dao, QueryCallback mQueryCallback) {
            mAsyncTaskDao = dao;
            this.queryCallback = mQueryCallback;
        }

        @Override
        protected List<Warike> doInBackground(Void... voids) {
            return mAsyncTaskDao.getAll();
        }

        @Override
        protected void onPostExecute(List<Warike> mPlaces) {
            super.onPostExecute(mPlaces);
            if(queryCallback!=null){
                if(mPlaces!=null){
                    queryCallback.onSuccess(mPlaces);
                }else {
                    queryCallback.onFailure(new Exception("Error en base de datos"));
                }
            }
        }
    }

    private static class InsertAsyncTask extends AsyncTask<Warike, Void, Void> {

        private final WarikeDao mAsyncTaskDao;

        InsertAsyncTask(WarikeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Warike... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


    //callback
    public interface QueryCallback{
        void onSuccess(List<Warike> places);
        void onFailure(Exception e);
    }
}
