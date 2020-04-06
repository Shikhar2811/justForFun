#!/bin/bash
#
#using arrays as data structure
#

arr=()

while [ 0 ]
do
    echo -e "1. Add an element to the array "
    echo -e "2. Remove an element from the array "
    echo -e "3. Show total no. of elements "
    echo -e "4. Display all the elements "
    echo -e "5. Show element of entered index "
    echo -e "6. Show index of entered element "
    echo 'Press CTRL+C to exit.'

    echo -e "\nEnter your choice : \c"
    read choice

    case $choice in
        "1" )
            echo -e "\nEnter the element to be added : \c" 
            read element
            if [ ${#arr[@]} -eq 0 ]
            then
                arr[0]=$element
            else
                len="${#arr[@]}"
                arr[$len]=$element
            fi 
            echo -e "$element added successfully !\n" ;;               
        "2" )
            if [ ${#arr[@]} -eq 0 ]
            then
                echo -e "\nArray already empty !\n" 
            else
                len="${#arr[@]}"
                idx=` expr $len - 1 `
                echo -e "\n ${arr[$idx]} has been removed ! \n"
                unset arr[$idx]
            fi ;;
        "3" )
            echo -e "\nTotal no of elements are : ${#arr[@]} \n" ;;
        "4" )
            echo -e "\nAll the elements of this array are - \n ${arr[@]} \n" ;;
        "5" )
            echo -e "\nEnter the index : \c"
            read indx
            echo -e "The element at index $indx is : ${arr[indx]} \n"
            echo -e "If you don't see the element , it's because that index is empty or the input value is not an index \n" ;;
        "6" )
            #echo -e "Enter the element : \c"
            #read elem
            echo "\nThis feature is still upcoming\n" ;;
        * )
            echo "\nInvalid input\n" ;;
    esac
done
    