package com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.presenter.UserPresenter;
import com.retrofit.R;
import com.view.IUserView;


public class MainActivity_1 extends AppCompatActivity implements View.OnClickListener,IUserView {

    UserPresenter presenter;
    EditText id,first,last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_1);

        findViewById(R.id.save).setOnClickListener(this);
        findViewById(R.id.load).setOnClickListener(this);
        id = (EditText) findViewById(R.id.id);
        first = (EditText) findViewById(R.id.first);
        last = (EditText) findViewById(R.id.last);

        presenter = new UserPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                presenter.saveUser(getID(), getFristName(), getLastName());
                break;
            case R.id.load:
                presenter.loadUser(getID());
                break;
            default:
                break;
        }
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getFristName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setFirstName(String firstName) {

    }

    @Override
    public void setLastName(String lastName) {

    }

}
