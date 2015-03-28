/*
 * Copyright (C) 2015 Roberto Estivill
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package yts.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("background_image")
    public String background;

    @SerializedName("small_cover_image")
    public String smallCover;

    @SerializedName("medium_cover_image")
    public String mediumCover;

    @SerializedName("large_cover_image")
    public String largeCover;

    @SerializedName("medium_screenshot_image1")
    public String mediumScreenshot1;

    @SerializedName("medium_screenshot_image2")
    public String mediumScreenshot2;

    @SerializedName("medium_screenshot_image3")
    public String mediumScreenshot3;

    @SerializedName("large_screenshot_image1")
    public String largeScreenshot1;

    @SerializedName("large_screenshot_image2")
    public String largeScreenshot2;

    @SerializedName("large_screenshot_image3")
    public String largeScreenshot3;
}