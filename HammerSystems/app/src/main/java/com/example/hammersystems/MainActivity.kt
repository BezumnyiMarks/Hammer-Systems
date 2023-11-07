package com.example.hammersystems

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.hammersystems.Data.AppBarCollapsedHeight
import com.example.hammersystems.Data.AppBarExpendedHeight
import com.example.hammersystems.Data.BottomNavItem
import com.example.hammersystems.ui.theme.HammerSystemsTheme
import com.example.hammersystems.ui.theme.LightRedOrange
import com.example.hammersystems.ViewModels.MainViewModel
import com.example.hammersystems.ui.theme.PurpleGrey80
import com.example.hammersystems.ui.theme.RedOrange
import com.example.hammersystems.Data.Shapes
import com.example.hammersystems.Data.TabItem
import com.example.hammersystems.Data.allMeals
import com.example.hammersystems.Data.lettersListIndex
import com.google.accompanist.insets.LocalWindowInsets
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

import kotlin.math.max
import kotlin.math.min

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HammerSystemsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BottomNavMenu(viewModel, lifecycleScope)
                }
            }
        }
    }
}

@Composable
fun TabLayout(viewModel: MainViewModel){
    val currentCategory = viewModel.category.collectAsState()
    Log.d("CATEGORY", currentCategory.value)
    val tabList = listOf(
        TabItem(
            title = "Пиццы",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            selectedBackgroudColor = LightRedOrange,
            unselectedBackgroudColor = Color.White
        ),
        TabItem(
            title = "Комбо",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            selectedBackgroudColor = LightRedOrange,
            unselectedBackgroudColor = Color.White
        ),
        TabItem(
            title = "Закуски",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            selectedBackgroudColor = LightRedOrange,
            unselectedBackgroudColor = Color.White
        ),
        TabItem(
            title = "Коктейли",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            selectedBackgroudColor = LightRedOrange,
            unselectedBackgroudColor = Color.White
        ),
        TabItem(
            title = "Кофе",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            selectedBackgroudColor = LightRedOrange,
            unselectedBackgroudColor = Color.White
        ),
        TabItem(
            title = "Напитки",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            selectedBackgroudColor = LightRedOrange,
            unselectedBackgroudColor = Color.White
        ),
        TabItem(
            title = "Десерты",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            selectedBackgroudColor = LightRedOrange,
            unselectedBackgroudColor = Color.White
        ),
        TabItem(
            title = "Соусы",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            selectedBackgroudColor = LightRedOrange,
            unselectedBackgroudColor = Color.White
        ),
        TabItem(
            title = "Другие товары",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            selectedBackgroudColor = LightRedOrange,
            unselectedBackgroudColor = Color.White
        )
    )
    var selectedTabIndex by remember{
        mutableIntStateOf(0)
    }

    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.White,
        divider = {},
        indicator = {},
        edgePadding = 0.dp
    ) {
        tabList.forEachIndexed{ index, item ->
            when(currentCategory.value){
                "a" -> selectedTabIndex = 0
                "b" -> selectedTabIndex = 1
                "c" -> selectedTabIndex = 2
                "d" -> selectedTabIndex = 3
                "e" -> selectedTabIndex = 4
                "f" -> selectedTabIndex = 5
                "g" -> selectedTabIndex = 6
                "h" -> selectedTabIndex = 7
                "i" -> selectedTabIndex = 8
                else -> selectedTabIndex = 0
            }
            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(
                    top = 8.dp,
                    bottom = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                )
            ){
                Tab(
                    modifier = Modifier.background(
                        color = if (index == selectedTabIndex) item.selectedBackgroudColor else item.unselectedBackgroudColor
                    ),
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                        viewModel.tabPosition.value = index
                    },
                    text = {
                        Text(
                            text = item.title,
                            color = if (index == selectedTabIndex) item.selectedColor else item.unselectedColor
                        )
                    },
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavMenu(viewModel: MainViewModel, lifecycleCoroutineScope: LifecycleCoroutineScope){
    val items = listOf(
        BottomNavItem(
            title = "Меню",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            icon = R.drawable.menu_icon
        ),
        BottomNavItem(
            title = "Профиль",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            icon = R.drawable.profile_icon
        ),
        BottomNavItem(
            title = "Корзина",
            selectedColor = RedOrange,
            unselectedColor = PurpleGrey80,
            icon = R.drawable.buscket_icon
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Surface {
        Scaffold(
            bottomBar = {
                BottomNavigation(backgroundColor = Color.White) {
                    items.forEachIndexed { index, bottomNavItem ->
                        BottomNavigationItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = bottomNavItem.icon),
                                    contentDescription = bottomNavItem.title,
                                    tint = if (selectedItemIndex == index) bottomNavItem.selectedColor else bottomNavItem.unselectedColor
                                )
                            }
                        )
                    }
                }
            }
        ) {
            MainPage(viewModel = viewModel, lifecycleCoroutineScope = lifecycleCoroutineScope)
        }
    }
}

@Composable
fun MainPage(viewModel: MainViewModel, lifecycleCoroutineScope: LifecycleCoroutineScope) {
    val scrollState = rememberLazyListState()
    val imageHeight = AppBarExpendedHeight - AppBarCollapsedHeight

    val maxOffset = with(LocalDensity.current) {
        imageHeight.roundToPx()
    } - LocalWindowInsets.current.systemBars.layoutInsets.top

    var firstVisibleItemScrollOffset = 0
    if (scrollState.firstVisibleItemScrollOffset >= 0 && scrollState.firstVisibleItemIndex == 0) {
        firstVisibleItemScrollOffset = scrollState.firstVisibleItemScrollOffset
    } else firstVisibleItemScrollOffset = 1000

    val offset = min(firstVisibleItemScrollOffset, maxOffset)

    val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset


    MealsList(scrollState = scrollState, viewModel, lifecycleCoroutineScope)

    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(top = AppBarCollapsedHeight)
            .height(
                AppBarExpendedHeight
            )
            .offset {
                IntOffset(x = 0, y = -offset)
            },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        alpha = 1f - offsetProgress
                    }
                    .background(color = Color.White)
            ) {
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    item {
                        val pictures =
                            listOf(R.drawable.pizza1, R.drawable.pizza2, R.drawable.pizza3)
                        for (i in 0..2) {
                            Box(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                                SetImage(
                                    image = pictures[i],
                                    modifier = Modifier.size(height = 150.dp, width = 300.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    contentScale = ContentScale.Fit,
                                )
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppBarCollapsedHeight),
                verticalArrangement = Arrangement.Center
            ) {
                TabLayout(viewModel)
            }
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .statusBarsPadding()
            .height(AppBarCollapsedHeight)
            .padding(horizontal = 16.dp)
    ) {
        Button(
            onClick = { },
            contentPadding = PaddingValues(),
            shape = Shapes.small,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Gray
            ),
            elevation = ButtonDefaults.elevation(),
            modifier = Modifier
                .width(38.dp)
                .height(38.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back Arrow",
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp),
                tint = Color.Black
            )
        }
    }
}

@OptIn(FlowPreview::class)
@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@Composable
fun MealsList(scrollState: LazyListState, viewModel: MainViewModel, lifecycleCoroutineScope: LifecycleCoroutineScope) {
    val tabPosition = viewModel.tabPosition.collectAsState()
    val lettersList = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i")
    val meals = viewModel.meals.collectAsState()
    val mealsLoading = viewModel.mealsLoading.collectAsState()

    if (!mealsLoading.value && lettersListIndex <= lettersList.lastIndex){
        viewModel.loadMeals(lettersList[lettersListIndex])
        lettersListIndex ++
    }

    var i = 0
    meals.value.meals.forEach { meal ->
        if (!allMeals.contains(meal) && i < 10){
            allMeals.add(meal)
            i++
        }
    }

    if (allMeals.isNotEmpty()) {
        if (allMeals[allMeals.lastIndex].strCategory == "i") {
            LaunchedEffect(scrollState) {
                snapshotFlow {
                    scrollState.firstVisibleItemIndex
                }
                    .debounce(100)
                    .collectLatest {
                        viewModel.category.value = allMeals[it].strCategory ?: ""
                    }
            }
            LazyColumn(
                contentPadding = PaddingValues(top = AppBarExpendedHeight, bottom = AppBarExpendedHeight *2),
                modifier = Modifier.padding(top = AppBarCollapsedHeight),
                state = scrollState
            ) {
                items(allMeals.size){
                    if (tabPosition.value != -1) {
                        for (i in allMeals.indices) {
                            if (allMeals[i].strCategory == lettersList[tabPosition.value]) {
                                lifecycleCoroutineScope.launch {
                                    scrollState.scrollToItem(i)
                                }
                                viewModel.tabPosition.value = -1
                                break
                            }
                        }
                    }
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                                Row(
                                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    SetImage(
                                        image = allMeals[it].strMealThumb,
                                        modifier = Modifier.size(150.dp),
                                        shape = RoundedCornerShape(10.dp),
                                        contentScale = ContentScale.Crop,
                                    )

                                    Spacer(modifier = Modifier.width(10.dp))

                                    Column {
                                        val ingredientsList = mutableListOf(
                                            allMeals[it].strIngredient1,
                                            allMeals[it].strIngredient2,
                                            allMeals[it].strIngredient3,
                                            allMeals[it].strIngredient4,
                                            allMeals[it].strIngredient5,
                                            allMeals[it].strIngredient6,
                                            allMeals[it].strIngredient7,
                                            allMeals[it].strIngredient8,
                                            allMeals[it].strIngredient9,
                                            allMeals[it].strIngredient10,
                                            allMeals[it].strIngredient11,
                                            allMeals[it].strIngredient12,
                                            allMeals[it].strIngredient13,
                                            allMeals[it].strIngredient14,
                                            allMeals[it].strIngredient15,
                                            allMeals[it].strIngredient16,
                                            allMeals[it].strIngredient17,
                                            allMeals[it].strIngredient18,
                                            allMeals[it].strIngredient19,
                                            allMeals[it].strIngredient20,
                                        )
                                        var ingredientsStr = ""
                                        ingredientsList.forEach {
                                            if (it != null && it != "")
                                                ingredientsStr += "$it, "
                                        }
                                        repeat(2) {
                                            ingredientsStr =
                                                ingredientsStr.replace(".$".toRegex(), "")
                                        }

                                        Text(
                                            text = allMeals[it].strMeal ?: "",
                                            color = Color.Black,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = ingredientsStr,
                                            color = Color.Black,
                                            fontSize = 12.sp
                                        )
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier
                                                .padding(start = 60.dp, top = 5.dp)
                                        ) {
                                            Card(
                                                shape = RoundedCornerShape(5.dp),
                                                border = BorderStroke(1.dp, RedOrange)
                                            ) {
                                                Text(
                                                    modifier = Modifier
                                                        .padding(5.dp),
                                                    text = "от 345 р",
                                                    color = RedOrange,
                                                    fontSize = 18.sp
                                                )
                                            }
                                        }
                                    }
                                }

                            Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SetImage(
    image: Any?,
    modifier: Modifier,
    shape: RoundedCornerShape,
    contentScale: ContentScale,
){
    Card(
        shape = shape,
        modifier = Modifier.background(color = Color.White)
    ) {
        if (image == null)
            Image(
                painter = painterResource(id = R.drawable.glad),
                contentDescription = null,
                modifier = modifier,
                alignment = Alignment.Center,
                contentScale = ContentScale.Fit
            )
        else
            GlideImage(
                model = image,
                contentDescription = null,
                modifier = modifier,
                contentScale = contentScale
            )
    }
}