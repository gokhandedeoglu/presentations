package com.telerik.app.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.telerik.app.utils.PostAdapter;
import com.telerik.app.R;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

import java.util.ArrayList;

import com.telerik.app.model.BaseViewModel;
import com.telerik.app.model.Post;

public class ListActivity extends Activity {

    private ArrayList<Post> posts;
    private PostAdapter postsAdapter;

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public ArrayAdapter<Post> getPostsAdapter() {
        return postsAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ListView listView = (ListView) findViewById(R.id.li_listView);
        this.posts = new ArrayList<Post>();
        this.postsAdapter = new PostAdapter(this, R.layout.listview_item_row, posts);

        listView.setAdapter(postsAdapter);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.argb(255, 52, 73, 94)));

        this.loadPosts(listView, this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Post selectedPost = (Post) parent.getAdapter().getItem(position);
                if (selectedPost != null) {
                    BaseViewModel.getInstance().setSelectedPost(selectedPost);
                    Intent i = new Intent(getBaseContext(), DetailViewActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    private void loadPosts(final ListView target, final ListActivity listActivity) {
        BaseViewModel.EverliveAPP.workWith().
                data(Post.class).
                getAll().
                executeAsync(new RequestResultCallbackAction<ArrayList<Post>>() {
                    @Override
                    public void invoke(RequestResult<ArrayList<Post>> requestResult) {
                        if (requestResult.getSuccess()) {
                            listActivity.getPosts().clear();
                            for (Post post : requestResult.getValue()) {
                                listActivity.getPosts().add(post);
                            }
                            target.post(new Runnable() {
                                @Override
                                public void run() {
                                    listActivity.getPostsAdapter().notifyDataSetChanged();
                                }
                            });
                        } else {

                        }
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            BaseViewModel.EverliveAPP.workWith().authentication().logout().executeAsync(null);
            BaseViewModel.getInstance().setLoggedUser(null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add : {
                Intent i = new Intent(this, CreateNewPostActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
            }
            default : return super.onOptionsItemSelected(item);
        }
    }
}
