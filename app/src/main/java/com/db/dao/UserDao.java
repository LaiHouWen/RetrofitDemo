package com.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.db.DaoSession;
import com.db.entity.User;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/**
 * Created by Administrator on 2016/6/13.
 * Dao层是创建Table ,对Table进行增删改查操作的
 * 创建表
 */
public class UserDao extends AbstractDao<User,Long>{

    /**
     * Properties of entity UserDao.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     * User 里字段 对应Table里的字段
     * public Property(int ordinal, Class<?> type, String name, boolean primaryKey, String columnName)
     * 排序，类名，字段名，是否主键，对应表字段名
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Sex = new Property(2, String.class, "sex", false, "SEX");
        public final static Property PhoneNumber = new Property(3, Long.class, "phoneNumber", false, "PHONE_NUMBER");
        public final static Property UpdateTime = new Property(4, Long.class, "updateTime", false, "UPDATE_TIME");
    };

    private DaoSession daoSession;

    public UserDao(DaoConfig config) {
        super(config);
    }

    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config);
        this.daoSession = daoSession;
    }

    /**
     *Creates the underlying database table
     * 创建数据库表
     */
    public static void createTable(SQLiteDatabase db,boolean ifNotExists){
        String constraint = ifNotExists?"IF NOT EXISTS ":"";
        db.execSQL("CREATE TABLE "+constraint+"\"USER\"{"+
            "\"_id\" INTEGER PRIMARY KEY ,"+
            "\"NAME\" TEXT,"+
            "\"SEX\" TEXT,"+
            "\"PHONE_NUMBER\" INTEGER,"+
            "\"UPDATE_TIME\" INTEGER);");

    }

    /**
     * Drops the underlying database table.
     * @param db
     * @param ifExists
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }



    @Override
    protected User readEntity(Cursor cursor, int offset) {
        User entity = new User(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1),
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2),
                cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3),
                cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));

        User entity = new User(//
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // sex
                cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // phoneNumber
                cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4) // updateTime
        );
        return entity;
    }

    @Override
    protected Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    @Override
    protected void readEntity(Cursor cursor, User entity, int offset) {

    }

    /**
     *  @inheritdoc
     *  绑定值
     * @param stmt
     * @param entity
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }

        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(3, sex);
        }

        Long phoneNumber = entity.getPhoneNumber();
        if (phoneNumber != null) {
            stmt.bindLong(4, phoneNumber);
        }

        Long updateTime = entity.getUpdateTime();
        if (updateTime != null) {
            stmt.bindLong(5, updateTime);
        }

    }

    @Override
    protected void attachEntity(User entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        return null;
    }

    @Override
    protected Long getKey(User entity) {
        return null;
    }

    @Override
    protected boolean isEntityUpdateable() {
        return false;
    }
}
