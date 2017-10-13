package com.aaron.jcpennyprepassignment.view.ContactListActivity;

import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaron.jcpennyprepassignment.R;
import com.aaron.jcpennyprepassignment.model.Contact;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.aaron.jcpennyprepassignment.R.id.imgContact;

/**
 * Created by aaron on 10/12/17.
 */

public class ContactListAdaptor extends RecyclerView.Adapter<ContactListAdaptor.ViewHolder> {
    ArrayList<Contact> contacts = new ArrayList<>();

    public ContactListAdaptor(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFirstName;
        TextView tvLastName;
        TextView tvStreetLocation;
        TextView tvCityLocation;
        TextView tvStateLocation;
        TextView tvPostalCode;
        TextView tvEmail;
        TextView tvCellNumber;
        TextView tvLanNumber;
        ImageView imgContact;
        public ViewHolder(View itemView) {
            super(itemView);
            tvFirstName = (TextView)itemView.findViewById(R.id.tvFirstName);
            tvLastName = (TextView)itemView.findViewById(R.id.tvLastName);
            tvStreetLocation = (TextView)itemView.findViewById(R.id.tvStreetLocation);
            tvCityLocation = (TextView)itemView.findViewById(R.id.tvCityLocation);
            tvStateLocation = (TextView)itemView.findViewById(R.id.tvStateLocation);
            tvPostalCode = (TextView)itemView.findViewById(R.id.tvPostalCode);
            tvEmail = (TextView)itemView.findViewById(R.id.tvEmail);
            tvCellNumber = (TextView)itemView.findViewById(R.id.tvCellNumber);
            tvLanNumber= (TextView)itemView.findViewById(R.id.tvLanNumber);
            imgContact = (ImageView) itemView.findViewById(R.id.imgContact);

        }
    }

    @Override
    public ContactListAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactListAdaptor.ViewHolder holder, int position) {
        final Contact currentNewContact = contacts.get(position);
        holder.tvFirstName.setText(currentNewContact.getFirstName());
        holder.tvLastName.setText(currentNewContact.getLastName());
        holder.tvStreetLocation.setText(currentNewContact.getStreetLocation());
        holder.tvCityLocation.setText(currentNewContact.getCityLocation());
        holder.tvStateLocation.setText(currentNewContact.getStateLocation());
        holder.tvPostalCode.setText(currentNewContact.getPostalCode());
        holder.tvEmail.setText(currentNewContact.geteMailAddress());
        holder.tvCellNumber.setText(currentNewContact.getCellPhoneNumber());
        holder.tvLanNumber.setText(currentNewContact.getLandPhoneNumber());
        Glide.with(holder.imgContact.getContext()).load(currentNewContact.getImageLargeSizedLocation()).into(holder.imgContact);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_item);
                dialog.setTitle(currentNewContact.getFirstName() + " " + currentNewContact.getLastName());

                TextView tvFirstName;
                TextView tvLastName;
                TextView tvStreetLocation;
                TextView tvCityLocation;
                TextView tvStateLocation;
                TextView tvPostalCode;
                TextView tvEmail;
                TextView tvCellNumber;
                TextView tvLanNumber;
                ImageView imgContact;

                tvFirstName = (TextView)dialog.findViewById(R.id.tvFirstName);
                tvLastName = (TextView)dialog.findViewById(R.id.tvLastName);
                tvStreetLocation = (TextView)dialog.findViewById(R.id.tvStreetLocation);
                tvCityLocation = (TextView)dialog.findViewById(R.id.tvCityLocation);
                tvStateLocation = (TextView)dialog.findViewById(R.id.tvStateLocation);
                tvPostalCode = (TextView)dialog.findViewById(R.id.tvPostalCode);
                tvEmail = (TextView)dialog.findViewById(R.id.tvEmail);
                tvCellNumber = (TextView)dialog.findViewById(R.id.tvCellNumber);
                tvLanNumber= (TextView)dialog.findViewById(R.id.tvLanNumber);
                imgContact = (ImageView) dialog.findViewById(R.id.imgContact);


                tvFirstName.setText(currentNewContact.getFirstName());
                tvLastName.setText(currentNewContact.getLastName());
                tvStreetLocation.setText(currentNewContact.getStreetLocation());
                tvCityLocation.setText(currentNewContact.getCityLocation());
                tvStateLocation.setText(currentNewContact.getStateLocation());
                tvPostalCode.setText(currentNewContact.getPostalCode());
                tvEmail.setText(currentNewContact.geteMailAddress());
                tvCellNumber.setText(currentNewContact.getCellPhoneNumber());
                tvLanNumber.setText(currentNewContact.getLandPhoneNumber());
                Glide.with(dialog.getContext()).load(currentNewContact.getImageLargeSizedLocation()).into(imgContact);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();



            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
