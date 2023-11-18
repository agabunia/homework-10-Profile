package com.example.homework_10_profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_10_profile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    fun setUp() {
        setOptionsRecyclerView()
    }

    fun setOptionsRecyclerView() {
        val optionRecyclerview = binding.rvActivities
        optionRecyclerview.layoutManager = LinearLayoutManager(this)
        val optionAdapter = OptionsAdapter()
        optionAdapter.submitOptionData(loadOptions())
        optionRecyclerview.adapter = optionAdapter
    }

    fun loadOptions(): MutableList<Options> {
        val optionList = mutableListOf<Options>()
        optionList.add(
            Options(1, R.drawable.user_profile_logo, "Edit Profile")
        )
        optionList.add(
            Options(2, R.drawable.address_icon, "Address")
        )
        optionList.add(
            Options(3, R.drawable.notification_icon, "Notification")
        )
        optionList.add(
            Options(4, R.drawable.payment_icon, "Payment")
        )
        optionList.add(
            Options(5, R.drawable.security_icon, "Security")
        )
        optionList.add(
            Options(6, R.drawable.language_icon, "Language", "English (US)")
        )
        optionList.add(
            Options(7, R.drawable.dark_mode_icon, "Dark Mode")
        )
        optionList.add(
            Options(8, R.drawable.privacy_icon, "Privacy Policy")
        )
        optionList.add(
            Options(9, R.drawable.help_icon, "Help Center")
        )
        optionList.add(
            Options(10, R.drawable.invite_icon, "Invite Friends")
        )
        optionList.add(
            Options(11, R.drawable.logout_icon, "Logout")
        )
        return optionList
    }
}