package com.example.singleactivitymuliplefragment;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NoteViewModel extends ViewModel {

    public MutableLiveData<Integer> clickedValue;
    public MutableLiveData<String> title;
    public MutableLiveData<String> note;

    public NoteViewModel(){
        title = new MediatorLiveData<String>();
        note = new MediatorLiveData<String>();
        clickedValue = new MediatorLiveData<Integer>();
        title.setValue("Title");
        note.setValue("note...");
        
        clickedValue.setValue(0);
    }
    public String getTitle() {
        return title.getValue().toString();
    }

    public void setTitle(String titleIn) {
        title.setValue(titleIn);
    }

    public String getNote() {
        return note.getValue().toString();
    }

    public void setNote(String noteIn) {
        note.setValue(noteIn);
    }
    public int getClickedValue(){
        return clickedValue.getValue();
    }
    public void setClickedValue(int value){
        clickedValue.setValue(value);
    }

}
