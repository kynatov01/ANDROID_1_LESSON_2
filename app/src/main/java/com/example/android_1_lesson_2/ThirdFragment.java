package com.example.android_1_lesson_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ThirdFragment extends Fragment {

    private final String admin = "admin";
    private EditText email, password;
    private Button btn_input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email = view.findViewById(R.id.et_Name);
        password = view.findViewById(R.id.et_Password);
        btn_input = view.findViewById(R.id.btn_Next);

        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nick = email.getText().toString().trim();
                String key = password.getText().toString();

                if (nick.equals("admin")&&key.equals("admin")){
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_container_1, new HomeFragment());
                    fm.popBackStack(R.id.home_fragment, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    ft.commit();
                }else if (!nick.equals("admin") || !key.equals("admin")) {
                    email.setError("Ошибка");
                    password.setError("Ошибка");
                }
            }
        });
    }
}