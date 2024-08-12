package com.example.usstatesapp

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class StateFlags {
    companion object {
        private val flagUrls = mapOf(
            "Alabama" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/5/5c/Flag_of_Alabama.svg",
                "https://www.50states.com/images/redesign/flags/al-largeflag.png"
            ),
            "Alaska" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/e/e6/Flag_of_Alaska.svg",
                "https://www.50states.com/images/redesign/flags/ak-largeflag.png"
            ),
            "Arizona" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/9/9d/Flag_of_Arizona.svg",
                "https://www.50states.com/images/redesign/flags/az-largeflag.png"
            ),
            "Arkansas" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/9/9d/Flag_of_Arkansas.svg",
                "https://www.50states.com/images/redesign/flags/ar-largeflag.png"
            ),
            "California" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/0/01/Flag_of_California.svg",
                "https://www.50states.com/images/redesign/flags/ca-largeflag.png"
            ),
            "Colorado" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/4/46/Flag_of_Colorado.svg",
                "https://www.50states.com/images/redesign/flags/co-largeflag.png"
            ),
            "Connecticut" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/9/96/Flag_of_Connecticut.svg",
                "https://www.50states.com/images/redesign/flags/ct-largeflag.png"
            ),
            "Delaware" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/c/c6/Flag_of_Delaware.svg",
                "https://www.50states.com/images/redesign/flags/de-largeflag.png"
            ),
            "Florida" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/f/f7/Flag_of_Florida.svg",
                "https://www.50states.com/images/redesign/flags/fl-largeflag.png"
            ),
            "Georgia" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/5/54/Flag_of_Georgia_%28U.S._state%29.svg",
                "https://www.50states.com/images/redesign/flags/ga-largeflag.png"
            ),
            "Hawaii" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/e/ef/Flag_of_Hawaii.svg",
                "https://www.50states.com/images/redesign/flags/hi-largeflag.png"
            ),
            "Idaho" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/a/a4/Flag_of_Idaho.svg",
                "https://www.50states.com/images/redesign/flags/id-largeflag.png"
            ),
            "Illinois" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/0/01/Flag_of_Illinois.svg",
                "https://www.50states.com/images/redesign/flags/il-largeflag.png"
            ),
            "Indiana" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/a/ac/Flag_of_Indiana.svg",
                "https://www.50states.com/images/redesign/flags/in-largeflag.png"
            ),
            "Iowa" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/a/aa/Flag_of_Iowa.svg",
                "https://www.50states.com/images/redesign/flags/ia-largeflag.png"
            ),
            "Kansas" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/d/da/Flag_of_Kansas.svg",
                "https://www.50states.com/images/redesign/flags/ks-largeflag.png"
            ),
            "Kentucky" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/8/8d/Flag_of_Kentucky.svg",
                "https://www.50states.com/images/redesign/flags/ky-largeflag.png"
            ),
            "Louisiana" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/e/e0/Flag_of_Louisiana.svg",
                "https://www.50states.com/images/redesign/flags/la-largeflag.png"
            ),
            "Maine" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/3/35/Flag_of_Maine.svg",
                "https://www.50states.com/images/redesign/flags/me-largeflag.png"
            ),
            "Maryland" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/a/a0/Flag_of_Maryland.svg",
                "https://www.50states.com/images/redesign/flags/md-largeflag.png"
            ),
            "Massachusetts" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/f/f2/Flag_of_Massachusetts.svg",
                "https://www.50states.com/images/redesign/flags/ma-largeflag.png"
            ),
            "Michigan" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/b/b5/Flag_of_Michigan.svg",
                "https://www.50states.com/images/redesign/flags/mi-largeflag.png"
            ),
            "Minnesota" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/b/b9/Flag_of_Minnesota.svg",
                "https://www.50states.com/images/redesign/flags/mn-largeflag.png"
            ),
            "Mississippi" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/4/42/Flag_of_Mississippi.svg",
                "https://www.50states.com/images/redesign/flags/ms-largeflag.png"
            ),
            "Missouri" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/5/5a/Flag_of_Missouri.svg",
                "https://www.50states.com/images/redesign/flags/mo-largeflag.png"
            ),
            "Montana" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/c/cb/Flag_of_Montana.svg",
                "https://www.50states.com/images/redesign/flags/mt-largeflag.png"
            ),
            "Nebraska" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/4/4d/Flag_of_Nebraska.svg",
                "https://www.50states.com/images/redesign/flags/ne-largeflag.png"
            ),
            "Nevada" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/f/f1/Flag_of_Nevada.svg",
                "https://www.50states.com/images/redesign/flags/nv-largeflag.png"
            ),
            "New Hampshire" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/2/28/Flag_of_New_Hampshire.svg",
                "https://www.50states.com/images/redesign/flags/nh-largeflag.png"
            ),
            "New Jersey" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/9/92/Flag_of_New_Jersey.svg",
                "https://www.50states.com/images/redesign/flags/nj-largeflag.png"
            ),
            "New Mexico" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/c/c3/Flag_of_New_Mexico.svg",
                "https://www.50states.com/images/redesign/flags/nm-largeflag.png"
            ),
            "New York" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/1/1a/Flag_of_New_York.svg",
                "https://www.50states.com/images/redesign/flags/ny-largeflag.png"
            ),
            "North Carolina" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/b/bb/Flag_of_North_Carolina.svg",
                "https://www.50states.com/images/redesign/flags/nc-largeflag.png"
            ),
            "North Dakota" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/e/ee/Flag_of_North_Dakota.svg",
                "https://www.50states.com/images/redesign/flags/nd-largeflag.png"
            ),
            "Ohio" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/4/4c/Flag_of_Ohio.svg",
                "https://www.50states.com/images/redesign/flags/oh-largeflag.png"
            ),
            "Oklahoma" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/6/6e/Flag_of_Oklahoma.svg",
                "https://www.50states.com/images/redesign/flags/ok-largeflag.png"
            ),
            "Oregon" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/b/b9/Flag_of_Oregon.svg",
                "https://www.50states.com/images/redesign/flags/or-largeflag.png"
            ),
            "Pennsylvania" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/f/f7/Flag_of_Pennsylvania.svg",
                "https://www.50states.com/images/redesign/flags/pa-largeflag.png"
            ),
            "Rhode Island" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/f/f3/Flag_of_Rhode_Island.svg",
                "https://www.50states.com/images/redesign/flags/ri-largeflag.png"
            ),
            "South Carolina" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/6/69/Flag_of_South_Carolina.svg",
                "https://www.50states.com/images/redesign/flags/sc-largeflag.png"
            ),
            "South Dakota" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/1/1a/Flag_of_South_Dakota.svg",
                "https://www.50states.com/images/redesign/flags/sd-largeflag.png"
            ),
            "Tennessee" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/9/9e/Flag_of_Tennessee.svg",
                "https://www.50states.com/images/redesign/flags/tn-largeflag.png"
            ),
            "Texas" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/f/f7/Flag_of_Texas.svg",
                "https://www.50states.com/images/redesign/flags/tx-largeflag.png"
            ),
            "Utah" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/f/f6/Flag_of_Utah.svg",
                "https://www.50states.com/images/redesign/flags/ut-largeflag.png"
            ),
            "Vermont" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/4/49/Flag_of_Vermont.svg",
                "https://www.50states.com/images/redesign/flags/vt-largeflag.png"
            ),
            "Virginia" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/4/47/Flag_of_Virginia.svg",
                "https://www.50states.com/images/redesign/flags/va-largeflag.png"
            ),
            "Washington" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/5/54/Flag_of_Washington.svg",
                "https://www.50states.com/images/redesign/flags/wa-largeflag.png"
            ),
            "West Virginia" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/2/22/Flag_of_West_Virginia.svg",
                "https://www.50states.com/images/redesign/flags/wv-largeflag.png"
            ),
            "Wisconsin" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/2/22/Flag_of_Wisconsin.svg",
                "https://www.50states.com/images/redesign/flags/wi-largeflag.png"
            ),
            "Wyoming" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/b/bc/Flag_of_Wyoming.svg",
                "https://www.50states.com/images/redesign/flags/wy-largeflag.png"
            ),
            "District of Columbia" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/d/d4/Flag_of_the_District_of_Columbia.svg",
                "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/primary-images/FlagofWashingtonDC.jpg"
            ),
            "Puerto Rico" to listOf(
                "https://upload.wikimedia.org/wikipedia/commons/2/28/Flag_of_Puerto_Rico.svg",
                "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/primary-images/FlagofPuertoRico.jpg"
            )
        )

        fun loadStateFlag(stateName: String, imageView: ImageView) {
            val urls = flagUrls[stateName] ?: listOf()

            if (urls.isEmpty()) {
                loadPlaceholder(imageView)
                return
            }

            Glide.with(imageView.context)
                .load(urls[0])
                .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .error(
                    Glide.with(imageView.context)
                        .load(urls.getOrNull(1))
                        .error(R.drawable.placeholder_flag)
                )
                .into(imageView)
        }

        private fun loadPlaceholder(imageView: ImageView) {
            Glide.with(imageView.context)
                .load(R.drawable.placeholder_flag)
                .into(imageView)
        }
    }
}