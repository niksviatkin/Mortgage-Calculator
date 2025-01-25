# Mortgage Calculator

## Overview

The Mortgage Calculator is a comprehensive Java application designed to assist users in calculating monthly payments for a fixed-term mortgage. It allows users to input various parameters such as loan amount, interest rate, number of terms, and compounding interval. The application follows the Model-View-Controller (MVC) architecture and features a modern graphical user interface (GUI) for ease of use.

## Features

- **Monthly Mortgage Payments Calculation**: Calculate monthly payments based on the loan amount, interest rate, and loan term.
- **Total Repayment Duration**: Determine the total duration required to repay the loan.
- **Compounding Intervals**: Support for different compounding intervals including Monthly, Weekly, Daily, and Continually.
- **Optional Costs**: Include additional costs such as property tax, down payment, homeowner's insurance, PMI, and HOA fees.
- **User-Friendly GUI**: Modern and intuitive interface for input and output.
- **Error Handling**: Robust error handling for invalid inputs with specific error messages.

## Project Structure

```
mortgage-calculator
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── niksviatkin
│   │   │   │   │   ├── controller
│   │   │   │   │   │   └── MortgageController.java
│   │   │   │   │   ├── model
│   │   │   │   │   │   └── MortgageModel.java
│   │   │   │   │   ├── view
│   │   │   │   │   │   └── MortgageView.java
│   │   │   │   │   └── Main.java
├── lib
├── .gitignore
└── README.md
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher.
- Any IDE that supports Java development (e.g., IntelliJ IDEA, Eclipse).

### Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/niksviatkin/mortgage-calculator.git
    ```
2. **Navigate to the project directory**:
    ```sh
    cd mortgage-calculator
    ```
3. **Build the project using Maven**:
    ```sh
    mvn clean install
    ```

### Running the Application

1. **Compile the Java files**:
    ```sh
    mvn compile
    ```
2. **Run the `Main.java` file**:
    ```sh
    mvn exec:java -Dexec.mainClass="com.niksviatkin.Main"
    ```

## Creating an Executable JAR File

1. **Build the project and create the executable JAR file**:
    ```sh
    mvn clean package
    ```

2. **Run the executable JAR file**:
    ```sh
    java -jar target/mortgage-calculator-1.0.jar
    ```

## Usage

1. **Enter the loan amount, interest rate, and number of terms** in the provided fields.
2. **Select the desired compounding interval** from the dropdown menu.
3. **Fill in optional fields** for property tax, down payment, homeowner's insurance, PMI, and HOA fees in the "Optional" tab.
4. **Click the "Calculate" button** to view the monthly payment and total repayment duration in the results area at the bottom of the screen.

## Example

Here is an example of how to use the Mortgage Calculator:

1. Enter `Loan Amount`: `425,000`
2. Enter `Interest Rate`: `3.5`
3. Enter `Number of Terms`: `30`
4. Select `Compounding Interval`: `Monthly`
5. (Optional) Enter `Property Tax`: `5,000`
6. (Optional) Enter `Down Payment`: `20,000`
7. (Optional) Enter `Homeowner's Insurance`: `1,200`
8. (Optional) Enter `PMI`: `1,500`
9. (Optional) Enter `HOA Fees`: `600`
10. Click `Calculate`

The results will be displayed in the results area at the bottom of the screen.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For any inquiries or feedback, please contact <niksviatkin@gmail.com>.

## Acknowledgments

- Special thanks to the open-source community for providing valuable resources and tools.
