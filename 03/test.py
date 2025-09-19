import subprocess
import shutil
import re
import os
import locale

def run_maven_test():
    # Set locale to ensure consistent encoding handling
    locale.setlocale(locale.LC_ALL, '')

    # Locate the mvn executable using shutil.which
    mvn_path = shutil.which('mvn')
    
    if mvn_path:
        # Path to the default test directory
        test_directory = 'tests'
        real_test_file = os.path.join(test_directory, 'realtests.java')
      
        # Check if 'realtests.java' exists in the test directory
        if os.path.exists(real_test_file):
            print(f"'realtests.java' found. Running tests in {real_test_file}.")
            # Run the build commands before running the tests
            build_command = [mvn_path, 'clean', 'compile']
            maven_command = [mvn_path, 'test', '-Dtest=realtests']  # Run only realtests.java
        else:
            print("Running tests.")
            # Run the build commands before running the tests
            build_command = [mvn_path, 'clean', 'compile']
            maven_command = [mvn_path, 'test']  # Run all default tests

        try:
            # Run the build command first because sometimes I ran into the problem that the code wasn't up to date when the tests ran
            build_result = subprocess.run(build_command, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            
            # Capture output and errors from the build process
            build_output_encoding = locale.getpreferredencoding()
            build_output = build_result.stdout.decode(build_output_encoding, errors='replace')
            build_error_output = build_result.stderr.decode(build_output_encoding, errors='replace')

            # Print the build output and errors
            print("Build output:")
            print(build_output)
            print("Build errors (if any):")
            print(build_error_output)

            # If the build was successful, run the tests
            if build_result.returncode == 0:
                # Run the appropriate mvn test command
                result = subprocess.run(maven_command, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
                
                # Capture output and errors using locale encoding
                output_encoding = locale.getpreferredencoding()
                output = result.stdout.decode(output_encoding, errors='replace')  # Replace undecodable characters
                error_output = result.stderr.decode(output_encoding, errors='replace')
                
                # Print the full command output
                print("Command output:")
                print(output)
                print("Command errors (if any):")
                print(error_output)
                
                # Use regular expressions to find the relevant lines in the output
                summary_match = re.search(r"Tests run: (\d+), Failures: (\d+), Errors: (\d+), Skipped: (\d+)", output)
                
                if summary_match:
                    total_tests = summary_match.group(1)
                    failures = summary_match.group(2)
                    
                    # Calculate the number of passed tests
                    passed_tests = int(total_tests) - int(failures)
                    
                    # Write the results to a file
                    with open("result.txt", "w", encoding='utf-8', errors='replace') as file:
                        file.write(f"{passed_tests}\t{total_tests}")
                    
                    print(f"Result file created with content: {passed_tests} {total_tests}")
                else:
                    print("Could not find test results in the output.")
            else:
                print("Build failed, skipping tests.")
                
        except subprocess.CalledProcessError as e:
            # Capture and print the output in case of an error
            output_encoding = locale.getpreferredencoding()
            output = e.stdout.decode(output_encoding, errors='replace')  # Replace undecodable characters
            error_output = e.stderr.decode(output_encoding, errors='replace')
            
            # Print everything, just in case
            print("An error occurred while running the command.")
            print("Command output:")
            print(output)
            print("Error output:")
            print(error_output)
    else:
        print("Maven executable not found. Write 'mvn −version' to CMD to check if you have it installed and install it if not. Check its pathing if it's installed.")

if __name__ == "__main__":
    run_maven_test()