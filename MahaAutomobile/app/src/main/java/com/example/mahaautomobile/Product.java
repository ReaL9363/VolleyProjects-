package com.example.mahaautomobile;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Mahabuba on 7/19/2016.
 */
public class Product implements Parcelable {
    static String mobile;
    ArrayList<String> image;
    String modelName;
    String modelYear;
    String brand;
    String condition;
    String bodyType;
    String fuelType;
    String engineCapacity;
    String mileage;
    String price;
    String discription;

    public Product() {
    }

    protected Product(Parcel in) {
        image = in.createStringArrayList();
        modelName = in.readString();
        modelYear = in.readString();
        brand = in.readString();
        condition = in.readString();
        bodyType = in.readString();
        fuelType = in.readString();
        engineCapacity = in.readString();
        mileage = in.readString();
        price = in.readString();
        discription = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public static String getMobile() {
        return mobile;
    }

    public static void setMobile(String mobile) {
        Product.mobile = mobile;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(image);
        dest.writeString(modelName);
        dest.writeString(modelYear);
        dest.writeString(brand);
        dest.writeString(condition);
        dest.writeString(bodyType);
        dest.writeString(fuelType);
        dest.writeString(engineCapacity);
        dest.writeString(mileage);
        dest.writeString(price);
        dest.writeString(discription);
    }
}
