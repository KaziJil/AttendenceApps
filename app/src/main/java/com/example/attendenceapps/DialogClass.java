package com.example.attendenceapps;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogClass extends DialogFragment {
    public static final String CLASS_ADD_DIALOG="addClass";
    onClickListener listener;
    public interface onClickListener{
        void onClick(String text1,String text2);
    }
    public void setListener(onClickListener listener){
        this.listener=listener;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog=null;
        if (getTag().equals(CLASS_ADD_DIALOG))dialog=getAddClassDialog();
        return dialog;
    }

    private Dialog getAddClassDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        View view= LayoutInflater.from(getActivity()).inflate(R.layout.dialog,null);
        builder.setView(view);
        TextView title=view.findViewById(R.id.dialog_title);
        title.setText("Add Class");

        EditText classEt=view.findViewById(R.id.dialog_class_name);
        EditText subjectEt=view.findViewById(R.id.dialog_subject_name);
        Button save=view.findViewById(R.id.dialog_add_button);
        Button cancel=view.findViewById(R.id.dialog_cancel_button);
        cancel.setOnClickListener(v ->dismiss());
        save.setOnClickListener(v-> {
            String className=classEt.getText().toString();
            String subjectName=subjectEt.getText().toString();
            listener.onClick(className,subjectName);
            dismiss();


        });
 return builder.create();
    }


}
